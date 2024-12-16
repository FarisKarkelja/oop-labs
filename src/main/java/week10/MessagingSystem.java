package week10;

import java.lang.annotation.*;

public class MessagingSystem {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CanSendMessage {
    }

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RequiresPermission {
        String level() default "admin";
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserPermission {
        String level() default "user";
    }

    @CanSendMessage
    @RequiresPermission
    public static void sendMessage(User user) {
        UserPermission permission = user.getClass().getAnnotation(UserPermission.class);
        if (permission.level().equals("admin")) {
            System.out.println("User " + user.getUsername() + " sent a message.");
        } else {
            System.out.println("User " + user.getUsername() + " can't send messages.");
        }
    }
}

abstract class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

@MessagingSystem.UserPermission
class RegularUser extends User {
    public RegularUser(String username) {
        super(username);
    }
}

@MessagingSystem.UserPermission(level = "admin")
class AdminUser extends User {
    public AdminUser(String username) {
        super(username);
    }
}

class Main {
    public static void main(String[] args) {
        User admin = new AdminUser("John");
        User regular = new RegularUser("Alice");

        MessagingSystem.sendMessage(admin);
        MessagingSystem.sendMessage(regular);
    }
}
