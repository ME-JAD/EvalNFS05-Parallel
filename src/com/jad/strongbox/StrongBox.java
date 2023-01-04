package com.jad.strongbox;

/**
 * The type Strong box.
 */
public class StrongBox {
    private final Code[] codes;
    private State state;

    /**
     * Instantiates a new Strong box with a nbCodes random french codes
     *
     * @param nbCodes the nb codes
     */
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

    /**
     * Try key on code and return the state of the try.
     * If the codeIndex is out of range, State.Open is returned.
     * If the strongBox is locked, State.Lock is returned.
     *
     * @param codeIndex the code index
     * @param key       the key
     * @return the state
     */
    public State tryKeyOnCode(final int codeIndex, final String key) {
        if (this.state == State.Lock) {
            return State.Lock;
        }
        State result = State.Open;
        if ( (codeIndex < this.codes.length) && (codeIndex >= 0) ) {
            result = this.codes[codeIndex].tryKey(key);
        }
        if (result == State.Lock) {
            this.state = State.Lock;
        }
        return result;
    }

    /**
     * Open code state and return the state of the try.
     * If the codeIndex is out of range, State.Open is returned.
     * If the strongBox is locked, State.Lock is returned.
     *
     * @param codeIndex the code index
     * @param key       the key
     * @return the state
     */
    public State openCode(final int codeIndex, final String key) {
        if (this.state == State.Lock) {
            return State.Lock;
        }
        State result = State.Open;
        if ( (codeIndex < this.codes.length) && (codeIndex >= 0) ) {
            result = this.codes[codeIndex].open(key);
        }
        if (result == State.Lock) {
            this.state = State.Lock;
        }
        return result;
    }

    /**
     * Open the strongBox.
     * If one of its codes is not opened, the strongBox becomes lock.
     *
     * @return the state
     */
    public State open() {
        for (int i = 0; i < this.countCodes(); i++) {
            if (this.codes[i].getState() == State.Close) {
                return State.Close;
            }
            if (this.codes[i].getState() == State.Lock) {
                this.state = State.Lock;
                return State.Lock;
            }
        }
        this.state = State.Open;
        return this.state;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public State getState() {
        if (this.state == State.Close) {
            return this.state;
        }
        for (int i = 0; i < this.countCodes(); i++) {
            if (this.codes[i].getState() == State.Close) {
                return State.Close;
            }
        }
        return this.state;
    }

    /**
     * Gets state from code by index.
     *
     * @param codeIndex the code index
     * @return the state from code by index
     */
    public State getStateFromCodeByIndex(int codeIndex) {
        if ( (codeIndex < this.codes.length) && (codeIndex >= 0) ) {
            return this.codes[codeIndex].getState();
        }
        return this.state;
    }

    /**
     * Count codes int.
     *
     * @return the int
     */
    public int countCodes() {
        return this.codes.length;
    }
}
