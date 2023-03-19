package gamersFun.com.example.gamersFun.exception;

public class BlogsNotFoundException extends Exception{

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public BlogsNotFoundException(String message){
        super(message);
        this.message = message;
    }
}
