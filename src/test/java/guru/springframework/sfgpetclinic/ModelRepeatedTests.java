package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@Tag("repeated")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface ModelRepeatedTests {
    @BeforeEach
    default void setUp(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " -------- " + "current: " + repetitionInfo.getCurrentRepetition());
    }
}
