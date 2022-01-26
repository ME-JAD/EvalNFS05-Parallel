package com.jad.strongbox;

public class StrongBox {
    private final Code[] codes;
    private State state;

    public StrongBox(int nbCodes) {
        if (nbCodes >= 0) {
            codes = new Code[nbCodes];
        } else {
            codes = new Code[0];
            this.state = State.Open;
        }
        for (int i = 0; i < this.codes.length; i++) {
            this.codes[i] = new Code();
        }
    }

    public State tryKeyOnCode(final int codeIndex, final String key) {
        if ( (codeIndex < this.codes.length) && (codeIndex >= 0) ) {
            return this.codes[codeIndex].tryKey(key);
        }
        return State.Open;
    }

    public State openCode(final int codeIndex, final String key) {
        if ( (codeIndex < this.codes.length) && (codeIndex >= 0) ) {
            return this.codes[codeIndex].open(key);
        }
        return State.Open;
    }

    public State getState() {
        return state;
    }

    public State getStateFromCodeByIndex(int codeIndex) {
        if ( (codeIndex < this.codes.length) && (codeIndex >= 0) ) {
            return this.codes[codeIndex].getState();
        }
        return State.Open;
    }

    public int countCodes() {
        return this.codes.length;
    }
}
