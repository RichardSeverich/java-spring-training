package org.jala.support;

/**
 * Constants Paths utility class.
 */
public final class Paths {

    private static final String VERSION = "/api/v1";
    private static final String USERS = "/users";
    private static final String ID = "/{id}";
    public static final String BASE_PATH_USERS = VERSION + USERS;
    public static final String BASE_PATH_USERS_WITH_ID = BASE_PATH_USERS + ID;

    /**
     * Private constructor for utility class.
     */
    private Paths() {

    }
}
