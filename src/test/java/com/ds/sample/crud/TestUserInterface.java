package com.ds.sample.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ds.sample.User;
import com.ds.sample.UserInterface;
import com.ds.sample.UserManagementException;

/**
 * Unit tests for UserInterface implementation(s).
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestConfiguration.class })
public class TestUserInterface {

    @Autowired
    private UserInterface service;

    /**
     * Tests behaviour or UserService creating a new user.
     * @throws Exception if test is failed for unexpected reason.
     */
    @Test
    public void test_createUser() throws Exception {
        assertThrows(NullPointerException.class, () -> service.create(null));
        assertThrows(UserManagementException.class, () -> service.create(new User()));

        User user = new User(null, "A Name", "Last name", "some@email.com");
        User result = service.create(user);
        assertNotNull(result, "Not null result expected");
        assertNotNull(result.getId(), "Not null result expected for user ID");
        assertNotSame(result, user, "New instance of object is expected, not the one given as argument");
        assertEquals(result.getEmail(), "some@email.com", "Invalid e-mail of created user");
        assertEquals(result.getFirstName(), "A Name", "Invalid name for the created user");
    }

    /**
     * Tests how list of Users is returned.
     * @throws Exception if test is failed for unexpected reason.
     */
    @Test
    public void test_listUsers() throws Exception {
        service.create(new User(null, "Another user", "Last name", "and e-mail"));

        List<User> result = service.list();
        assertNotNull(result, "Resulting list shall not be null");
        assertTrue(result.size() > 0, "Expected at least one (created) element in result");
        assertTrue(result.stream().anyMatch(
            user -> "Another user".equals(user.getFirstName()) && "and e-mail".equals(user.getEmail()))
            );
    }
}
