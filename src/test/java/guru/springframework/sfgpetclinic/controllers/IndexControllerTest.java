package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.exceptions.ValueNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test Proper view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view return");

        assertEquals("index", controller.index(), () -> "Another expensive message " +
                "Make me only if you have to");
    }

    @Test
    @DisplayName("Test exception")
    void oopsHandler() {
        assertThrows(ValueNotFoundException.class, () -> controller.oopsHandler());
    }

    @Disabled
    @Test
    @DisplayName("Demo of timeout")
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }

    @Disabled
    @Test
    @DisplayName("Demo of timeout")
    void testTimeOutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here 12344");
        });
    }
}