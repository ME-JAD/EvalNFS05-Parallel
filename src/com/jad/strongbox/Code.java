package com.jad.strongbox;

import com.jad.dictionaries.French;

import java.util.Random;

/**
 * The type Code.
 */
class Code {
    private State state = State.Close;
    private final String key;

    /**
     * Instantiates a new Code with a random French word
     */
    public Code() {
        French dictionary = French.getInstance();
        this.key = dictionary.getWordByIndex(new Random().nextInt(dictionary.countWords()));
    }

    /**
     * Gets state of the code.
     *
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * Try a key on the code and return if the key works.
     * If the code is already open, the code becomes lock.
     *
     * @param key the key
     * @return the state
     */
    public State tryKey(final String key) {
        if (this.state == State.Open) {
            this.state = State.Lock;
        }
        if (this.state == State.Lock) {
            return State.Lock;
        }
        return this.key.equals(key) ? State.Open: State.Close;
    }

    /**
     * Open a code with a key and return if the key works.
     * If the code is already open, the code becomes lock.
     * If the key doesn't work, the code becomes lock.
     *
     * @param key the key
     * @return the state
     */
    public State open(final String key) {
        if (this.state == State.Lock) {
            return State.Lock;
        }
        if (this.tryKey(key) == State.Close) {
            this.state = State.Lock;
        } else {
            this.state = State.Open;
        }
        return this.state;
    }
}
