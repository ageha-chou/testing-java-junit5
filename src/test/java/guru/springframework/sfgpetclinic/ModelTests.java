package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@Tag("models")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ModelTests {
    @BeforeEach
    default void setUp(TestInfo testInfo) {
        System.out.println("Running Test - " + testInfo.getDisplayName());
    }
}
