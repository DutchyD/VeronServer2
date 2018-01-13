package io.veron.user;

public class OfflineUser extends User {


    public OfflineUser() {
        super(new UserValidator());
    }
}
