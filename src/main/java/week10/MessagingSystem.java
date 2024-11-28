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
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserPermission {
    }

    @CanSendMessage
    public static void sendMessage(User user) {
        Class<?> userClass = user.getClass();
        if (userClass.isAnnotationPresent(UserPermission.class)) {
            if (user instanceof AdminUser) {
                System.out.println("Admin user " + user.getUsername() + " sent a message.");
            } else if (user instanceof RegularUser) {
                System.out.println("Regular user " + user.getUsername() + " is restricted from sending messages.");
            }
        } else {
            System.out.println("Unknown user type: No permission to send messages.");
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

@MessagingSystem.UserPermission
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
