package gamersFun.com.example.gamersFun.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@ControllerAdvice
public class GlopalExceptionHandler {

    @Value("${message.error.exception}")
    private String exceptionMessage;

    @Value("${message.error.duplicateRecord}")
    private String duplicateRecord;


    private MessageSource messageSource;


    @Autowired
    public GlopalExceptionHandler(MessageSource messageSource){
        this.messageSource = messageSource;
    }


    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable e) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<String>(e.getMessage(), status);
    }

  /*
   For rest Api handke exception
  @ExceptionHandler(InvalidFileException.class)
    @ResponseBody
    ResponseEntity<?> handleInvalidFileException(HttpServletRequest request, Throwable e) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<String>(e.getMessage(), status);
    }

    @ExceptionHandler(ImageTooSmallException.class)
    @ResponseBody
    ResponseEntity<?> handleSmallImages(HttpServletRequest request, Throwable e) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<String>(e.getMessage(), status);
    }*/

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    // method to handle validation error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<FieldValidationErrorDetails> handleValidationError(
            MethodArgumentNotValidException mNotValidException,
            HttpServletRequest request) {

        FieldValidationErrorDetails fErrorDetails =
                new FieldValidationErrorDetails();

        fErrorDetails.setError_timeStamp(new Date().getTime());
        fErrorDetails.setError_status(HttpStatus.BAD_REQUEST.value());
        fErrorDetails.setError_title("Field Validation Error");
        fErrorDetails.setError_detail("Input Field Validation Failed");
        fErrorDetails.setError_developer_Message(
                mNotValidException.getClass().getName());
        fErrorDetails.setError_path(request.getRequestURI());

        BindingResult result = mNotValidException.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        for (FieldError error : fieldErrors) {
            FieldValidationError fError = processFieldError(error);
            List<FieldValidationError> fValidationErrorsList =
                    fErrorDetails.getErrors().get(error.getField());
            if (fValidationErrorsList == null) {
                fValidationErrorsList =
                        new ArrayList<>();
            }
            fValidationErrorsList.add(fError);
            fErrorDetails.getErrors().put(
                    error.getField(), fValidationErrorsList);
        }
        return new ResponseEntity<FieldValidationErrorDetails>(
                fErrorDetails, HttpStatus.BAD_REQUEST);
    }


    // method to process field error
    private FieldValidationError processFieldError(final FieldError error) {
        FieldValidationError fieldValidationError =
                new FieldValidationError();
        if (error != null) {
            Locale currentLocale = LocaleContextHolder.getLocale();
            String msg = messageSource.getMessage(error.getDefaultMessage(),null,currentLocale);
            fieldValidationError.setFiled(error.getField());
            fieldValidationError.setType(TrayIcon.MessageType.ERROR);
            //fieldValidationError.setMessage(error.getDefaultMessage());
            fieldValidationError.setMessage(msg);
        }
        return fieldValidationError;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("message",exception.getMessage());
        modelAndView.getModel().put("status",getStatus(request));
        modelAndView.getModel().put("url",request.getRequestURL());
        modelAndView.getModel().put("exception",exception);
        modelAndView.setViewName("app.exception");
        return modelAndView;
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ModelAndView runtimeException(HttpServletRequest request, Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("message",exception.getMessage());
        modelAndView.getModel().put("status",getStatus(request));
        modelAndView.getModel().put("url",request.getRequestURL());
        modelAndView.getModel().put("exception",exception);
        modelAndView.setViewName("app.exception");
        return modelAndView;
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ModelAndView integrityViolation(HttpServletRequest request, Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("message",exception.getMessage());
        modelAndView.getModel().put("url",request.getRequestURL());
        modelAndView.getModel().put("exception",exception);
        modelAndView.setViewName("app.exception");
        return modelAndView;
    }

}
