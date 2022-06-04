package gamersFun.com.example.gamersFun.action;

public enum ActionEnum {

    ADD_BLOG("addBlogs"),EDIT_BLOG("editBlog"),UNSUPPORTED("editBlog");

    private String action;

    ActionEnum(String action){
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    @Override
    public String toString() {
        return this.action;
    }
}
