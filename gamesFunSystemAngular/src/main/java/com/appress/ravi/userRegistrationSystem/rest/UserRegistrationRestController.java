package com.appress.ravi.userRegistrationSystem.rest;

import com.appress.ravi.userRegistrationSystem.dto.ImageModel;
import com.appress.ravi.userRegistrationSystem.dto.UserDTO;
import com.appress.ravi.userRegistrationSystem.exception.CustomErrorType;
import com.appress.ravi.userRegistrationSystem.repository.ImageRepository;
import com.appress.ravi.userRegistrationSystem.repository.UserJpaRepository;
import org.hibernate.event.spi.DeleteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/api/user")
public class UserRegistrationRestController {

    public static final Logger logger =
            LoggerFactory.getLogger(UserRegistrationRestController.class);

    private UserJpaRepository userJpaRepository;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    public void setUserJpaRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    //http://localhost:8080/api/user/
    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> listAllUsers() {
        List<UserDTO> users = userJpaRepository.findAll();

        if (users.isEmpty()) {
            return new ResponseEntity<List<UserDTO>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
    }


    // consumes accept json data only from the request body
    //@PostMapping shortcut for     @RequestMapping(value="/", method=RequestMethod.POST)

    /*{
        "name":"Ravi Kant Soni",
            "address":"Lashkariganj, Sasaram, Rohtas, Bihar, pin-821115",
            "email":"ravikantsoni.author@gmail.com"
    }*/
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody final UserDTO user) {
        logger.info("Creating User : {}", user);

        if (userJpaRepository.findByName(user.getName()) != null) {
            logger.error("Unable to create. A User with name {} already exist", user.getName());
            return new ResponseEntity<UserDTO>(new CustomErrorType("Unable to create new user. A User with name " + user.getName() + " already exist."), HttpStatus.CONFLICT);
        }

        userJpaRepository.save(user);
        return new ResponseEntity<UserDTO>(user, HttpStatus.CREATED);
    }

    // Create == Post
    // Read == Get
    // Update == Put
    // DELETE == Delete

    /*
     * 200 OK  : The request has succeeded (this is a standard response for a successful HTTP request).
     * 201 CREATED : The request has been fulfilled, and the request successfully created a new resource.
     * 204 No content : The request has processed successfully but is not returning any content.
     * 400 bad request : The request could not be fulfilled because of bad syntax.
     * 401 unauthorized : The request requires user authorization.
     * 403  Forbidden  : The server refuses to fulfill the request.
     * 404 Not found : The requested resource could not be found.
     * 409 conflict : The request cannot be completed because of a resource conflict.
     *
     * */


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") final Long id) {
        Optional<UserDTO> user = userJpaRepository.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<UserDTO>(user.get(), HttpStatus.OK);
        }

        return new ResponseEntity<UserDTO>(
                new CustomErrorType("User with id "
                        + id + " not found"), HttpStatus.NOT_FOUND);

    }


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable("id") final Long id, @RequestBody UserDTO user) {

        // fetch user based on id and set it to currentUser object of type UserDTO
        Optional<UserDTO> currentUser = userJpaRepository.findById(id);

        // update currentUser object data  with user object data
        if (currentUser.isPresent()) {
            currentUser.get().setName(user.getName());
            currentUser.get().setAddress(user.getAddress());
            currentUser.get().setEmail(user.getEmail());
            // save currentUser obejct
            userJpaRepository.saveAndFlush(currentUser.get());
            //return ResponseEntity object
            return new ResponseEntity<UserDTO>(currentUser.get(), HttpStatus.OK);
        }

        return new ResponseEntity<UserDTO>(
                new CustomErrorType("Unable to upate. User with id "
                        + id + " not found."), HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") final Long id) {
        Optional<UserDTO> user = userJpaRepository.findById(id);
        if (user.isPresent()) {
            userJpaRepository.deleteById(id);
            return new ResponseEntity<UserDTO>(new CustomErrorType("Deleted User with id " + id + "."), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<UserDTO>(
                new CustomErrorType("Unable to delete. User with id "
                        + id + " not found."), HttpStatus.NOT_FOUND);
    }

}
