package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Buck");
        owner.setCity("Key West");
        owner.setTelephone("1231231234");

        assertAll("Properties Test",
            () -> assertAll("Person Properties",
                    () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                    () -> assertEquals("Buck", owner.getLastName(), "Last name did not match")),
            () -> assertAll("Owner Properties",
                    () -> assertEquals("Key West", owner.getCity(), "City did not match"),
                    () -> assertEquals("1231231234", owner.getTelephone(), "Phone did not match"))
        );

        assertThat(owner.getCity(), is("Key West"));
    }
}