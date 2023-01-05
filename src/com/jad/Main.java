package com.jad;

import com.jad.dictionaries.French;
import com.jad.strongbox.State;
import com.jad.strongbox.StrongBox;
import com.jad.view.StrongBoxView;

public class Main {
    private static final int delayInMilliseconds = 5000;
    private static final int nbCodes = 10000;

    public static void main(String[] args) {
        StrongBox strongBox = new StrongBox(nbCodes);
        StrongBoxView.display(strongBox, delayInMilliseconds);
        French french = French.getInstance();

        for (int j = 0; j < strongBox.countCodes(); j++) {
            for (int i = 0; i < french.countWords(); i++) {
                if (strongBox.tryKeyOnCode(j, french.getWordByIndex(i)) == State.Open) {
                    if (strongBox.openCode(j, french.getWordByIndex(i)) != State.Open) {
                        j = strongBox.countCodes();
                    }
                    i = french.countWords();
                }
            }
        }

        if (strongBox.open() != State.Open) {
            System.out.println("Loose !");
        } else {
            System.out.println("Goal !");
        }
    }
}
