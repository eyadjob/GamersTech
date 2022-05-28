package gamersFun.com.example.gamersFun.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum UserRole {
    ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER"), ROLE_BLOGGER("ROLE_BLOGGER");

    public final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public static UserRole getRoleByName(String roleName) {
        for (UserRole stat : UserRole.values()) {
            if (stat.getRoleName().equals(roleName)) {
                return stat;
            }
        }
        throw new IllegalArgumentException("Illegal user role value: " + roleName);
    }

    public static List<String> getRoleNames() {
        return Arrays.stream(UserRole.values()).map(Enum::name).collect(Collectors.toList());
    }

    public String getRoleName() {
        return roleName;
    }

}
