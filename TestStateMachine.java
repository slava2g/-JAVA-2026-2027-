package org.example;

public class TestStateMachine {

    public enum State {
        S, STATE_1, STATE_2, STATE_3, F
    }

    public State process(String input) {
        if (input == null || input.isEmpty()) {
            return State.S;
        }

        State currentState = State.S;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (currentState == State.F) {
                break;
            }

            switch (currentState) {
                case S:
                    if (c == 'T') {
                        currentState = State.STATE_1;
                    }
                    break;

                case STATE_1:
                    if (c == 'E') {
                        currentState = State.STATE_2;
                    } else if (c == 'T') {
                        currentState = State.STATE_1;
                    } else {
                        currentState = State.S;
                    }
                    break;

                case STATE_2:
                    if (c == 'S') {
                        currentState = State.STATE_3;
                    } else if (c == 'T') {
                        currentState = State.STATE_1;
                    } else {
                        currentState = State.S;
                    }
                    break;

                case STATE_3:
                    if (c == 'T') {
                        currentState = State.F;
                    } else {
                        currentState = State.S;
                    }
                    break;

                case F:
                    break;
            }
        }

        return currentState;
    }
}
