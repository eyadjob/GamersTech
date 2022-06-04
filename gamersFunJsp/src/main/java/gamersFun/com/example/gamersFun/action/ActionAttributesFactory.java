package gamersFun.com.example.gamersFun.action;

import gamersFun.com.example.gamersFun.action.implementation.AddBlogAttributes;
import gamersFun.com.example.gamersFun.action.implementation.EditBlogAttributes;
import gamersFun.com.example.gamersFun.enums.UserRole;

import java.util.Arrays;
import java.util.Optional;

public class ActionAttributesFactory {
    public static IAction getActionAttributes(String action){
        ActionEnum actionEnum = Arrays.stream(ActionEnum.values())
                .filter(actionEnum1 -> actionEnum1.getAction()
                .equals(action)).findFirst().orElse(ActionEnum.UNSUPPORTED);
        switch (actionEnum){
            case ADD_BLOG:
                return new AddBlogAttributes();
            case EDIT_BLOG:
                return new EditBlogAttributes();
            default:
                return null;
        }

    }

}
