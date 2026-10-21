package registration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    private final UserRegistration reg = new UserRegistration();

    @Test
    void validEmailReturnsTrue() {
        assertTrue(reg.validateEmail("student@example.com"));
    }

    @Test
    void emailWithoutAtReturnsFalse() {
        assertFalse(reg.validateEmail("not-an-email"));
    }

    @Test
    void validPasswordReturnsTrue() {
        assertTrue(reg.validatePassword("secret123"));
    }

    @Test
    void shortPasswordReturnsFalse() {
        assertFalse(reg.validatePassword("123"));
    }

    @Test
    void matchingPasswordsRegisterSuccessfully() {
        assertDoesNotThrow(() ->
            reg.register("student@example.com", "secret123", "secret123", "student"));
    }

    @Test
    void mismatchedPasswordsThrowException() {
        assertThrows(RegistrationException.class, () ->
            reg.register("student@example.com", "secret123", "different", "student"));
    }  
}