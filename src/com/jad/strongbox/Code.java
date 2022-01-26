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
        if (this.state == State.Open) {
            this.state = State.Lock;
        }
        if (this.state == State.Lock) {
            return State.Lock;
        }
        return this.key.equals(key) ? State.Open: State.Close;
    }

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
