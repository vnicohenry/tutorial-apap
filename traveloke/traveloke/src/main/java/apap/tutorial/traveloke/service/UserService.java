package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

public interface UserService {
    UserModel addUser(UserModel user);

    String encrypt(String password);

    boolean passwordMatch(String newPassword, UserModel user);

    boolean validatePassword(String password);

    UserModel findUserByUsername(String username);
}
