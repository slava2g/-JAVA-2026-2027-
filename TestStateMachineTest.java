package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestStateMachineTest {
    private final TestStateMachine fsm = new TestStateMachine();

    @ParameterizedTest
    @CsvSource({
            "'',   T, STATE_1", "'',   E, S",       "'',   S, S",       "'',   X, S",
            "T,    T, STATE_1", "T,    E, STATE_2", "T,    S, S",       "T,    X, S",
            "TE,   T, STATE_1", "TE,   E, S",       "TE,   S, STATE_3", "TE,   X, S",
            "TES,  T, F",       "TES,  E, S",       "TES,  S, S",       "TES,  X, S",
            "TEST, T, F",       "TEST, E, F",       "TEST, S, F",       "TEST, X, F"
    })
    void checksEveryTransition(String prefix, char symbol, State expected) {
        assertEquals(expected, fsm.process(prefix + symbol));
    }

    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, F",
            "TESTabc, F",
            "abcTEST, F",
            "TESTTEST, F",
            "abcTES, STATE_3",
            "abcTE, STATE_2",
            "abcT, STATE_1",
            "abcdef, S",
            "test, S",
            "TE STx, S"
    })
    void returnsFinalState(String input, State expected) {
        assertEquals(expected, fsm.process(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void startsInStateS(String input) {
        assertEquals(State.S, fsm.process(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"TTEST", "TETEST", "abcTTTTESTxyz", "abcTETETETESTxyz"})
    void findsTestAfterRepeatedPrefix(String input) {
        assertEquals(State.F, fsm.process(input));
    }
}