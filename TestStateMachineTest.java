package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStateMachineTest {

    private final TestStateMachine fsm = new TestStateMachine();

    @ParameterizedTest
    @CsvSource({
            "'abcTESTabc', F",
            "'TEST', F",
            "'abcTES', STATE_3",
            "'abcTE', STATE_2",
            "'abcT', STATE_1",
            "'abcdef', S",
            "'', S",
            "'TTEST', F",
            "'TESTEST', F"
    })
    void testStateMachineCases(String input, TestStateMachine.State expectedState) {
        TestStateMachine.State actualState = fsm.process(input);
        assertEquals(expectedState, actualState, "Failed for input: " + input);
    }
}
