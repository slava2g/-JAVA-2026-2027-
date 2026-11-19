package org.example;

public enum State {
    S("S"),
    STATE_1("1"),
    STATE_2("2"),
    STATE_3("3"),
    F("F");

    private final String label;

    State(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}

