package com.jad.strongbox;

import com.jad.dictionaries.French;

import java.util.Random;

class Code {
    private State state = State.Close;
    private final String key;

    public Code() {
        French dictionary = French.getInstance();
        this.key = dictionary.getWordByIndex(new Random().nextInt(dictionary.countWords()));
    }

    public State getState() {
        return state;
    }

    public State tryKey(final String key) {
        return this.key.equals(key) ? State.Open: State.Close;
    }

    public State open(final String key) {
        this.state = this.tryKey(key);
        return this.state;
    }
}
