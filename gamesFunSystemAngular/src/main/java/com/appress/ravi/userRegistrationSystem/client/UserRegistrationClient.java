package com.appress.ravi.userRegistrationSystem.client;

import com.appress.ravi.userRegistrationSystem.dto.UserDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class UserRegistrationClient {

    public static RestTemplate restTemplate = new RestTemplate();
    public static final String USER_REGESTRATION_BASE_URL = "http://localhost:8381/api/user/";
    private static final String securityUserName = "admin";
    private static final String securityUserPassword = "password";



    public UserDTO getUserById(final Long userId){
        return restTemplate.getForObject(USER_REGESTRATION_BASE_URL + "/{id}",UserDTO.class,userId);
    }

    public UserDTO[] getAllUsers() {
        return restTemplate.getForObject(
                USER_REGESTRATION_BASE_URL,
                UserDTO[].class);
    }

    public UserDTO createUser(final UserDTO user) {
        return restTemplate.postForObject(
                USER_REGESTRATION_BASE_URL,
                user,
                UserDTO.class);
    }

    public void updateUser(final Long userId, final UserDTO user) {
        restTemplate.put(
                USER_REGESTRATION_BASE_URL + "/{id}",
                user,
                userId);
    }

    public void deleteUser(final Long userId) {
        restTemplate.delete(
                USER_REGESTRATION_BASE_URL + "/{id}",
                userId);
    }

    public void deleteUserById(Long userId) {

        String userCredential =
                securityUserName + ":" + securityUserPassword;
        byte[] base64UserCredentialData =
                Base64.encodeBase64(userCredential.getBytes());

        HttpHeaders authenticationHeaders = new HttpHeaders();
        authenticationHeaders.set("Authorization",
                "Basic " + new String(base64UserCredentialData));

        HttpEntity<Void> httpEntity =
                new HttpEntity<Void>(authenticationHeaders);

        restTemplate.exchange(USER_REGESTRATION_BASE_URL + "/{id}",
                HttpMethod.DELETE, httpEntity, Void.class, userId);
    }



    public ResponseEntity<UserDTO> getUserByIdUsingExchangeAPI(final Long userId) {
        HttpEntity<UserDTO> httpEntity = new HttpEntity<UserDTO>(new UserDTO());
        return restTemplate.exchange(USER_REGESTRATION_BASE_URL + "/{id}",
                HttpMethod.GET, httpEntity, UserDTO.class,        userId);
    }

    public static void main(String[] args) {
        UserRegistrationClient userRegistrationClient = new UserRegistrationClient();
        UserDTO userDTO = userRegistrationClient.getUserById(11L);
        System.out.println("User id - " + userDTO);




        UserDTO user = new UserDTO();
        user.setName("Soniya Singh");
        user.setAddress("JP Nagar; Bangalore; India");
        user.setEmail("test@test.com");

        UserDTO newUser = userRegistrationClient.createUser(user);
        System.out.println(newUser.getId());

        UserDTO user2 = userRegistrationClient.getUserById(11L);
        System.out.println("old user name: " + user2.getName());

        user.setName("Ravi Kant Soni");
        userRegistrationClient.updateUser(11L, user2);
        System.out.println("updated user name: " + user2.getName());


        ResponseEntity<UserDTO> responseEntity = userRegistrationClient.getUserByIdUsingExchangeAPI(11L);
        UserDTO user3 = responseEntity.getBody();
        System.out.println(user3.getName());

    }
}
