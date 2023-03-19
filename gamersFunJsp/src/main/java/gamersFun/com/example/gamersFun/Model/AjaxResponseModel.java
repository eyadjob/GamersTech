package gamersFun.com.example.gamersFun.Model;

public class AjaxResponseModel<T>{
    public T getMessage() {
        return message;
    }

    private T message;

    public void setMessage(T message) {
        this.message = message;
    }

    public AjaxResponseModel(T message){
        this.message = message;
    }

}
