package org.example;

public class TestStateMachine {
    public State process(String input) {
        if (input == null) {
            return State.S;
        }

        State state = State.S;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            state = switch (state) {
                case S -> symbol == 'T' ? State.STATE_1 : State.S;

                case STATE_1 -> switch (symbol) {
                    case 'E' -> State.STATE_2;
                    case 'T' -> State.STATE_1;
                    default -> State.S;
                };

                case STATE_2 -> switch (symbol) {
                    case 'S' -> State.STATE_3;
                    case 'T' -> State.STATE_1;
                    default -> State.S;
                };

                case STATE_3 -> symbol == 'T' ? State.F : State.S;
                case F -> State.F;
            };
        }

        return state;
    }
}