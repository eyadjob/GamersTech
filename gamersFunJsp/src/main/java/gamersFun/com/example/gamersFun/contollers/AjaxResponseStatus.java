package gamersFun.com.example.gamersFun.contollers;

public class AjaxResponseStatus {
    public String getMessage() {
        return message;
    }

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public AjaxResponseStatus(String message){
        this.message = message;
    }
}
