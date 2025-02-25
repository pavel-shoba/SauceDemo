package tests;

import constructors.User;

public class Preconditions extends BaseTest {
    /**
     * List of users to test Login page with different cases
     */
    public static User user = User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build();

    public static User userWithEmptyFields = User.builder()
            .username("")
            .password("")
            .build();

    public static User userWithEmptyUsername = User.builder()
            .username("")
            .password(PASSWORD)
            .build();

    public static User userWithEmptyPassword = User.builder()
            .username(USERNAME)
            .password("")
            .build();

    public static User userWithIncorrectFields = User.builder()
            .username("asdgasd")
            .password("asdgasdg")
            .build();
}
