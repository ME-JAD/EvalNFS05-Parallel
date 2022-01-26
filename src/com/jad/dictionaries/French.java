package com.jad.dictionaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class French {
    private static final String fileName = "french.txt";
    private static French instance = null;
    private final String[] words;

    private French() {
        String word;
        int nbWords = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(French.fileName));
            nbWords = - 1;
            do {
                word = reader.readLine();
                nbWords++;
            } while (word != null);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        words = new String[nbWords];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(French.fileName));
            for (int i = 0; i < nbWords; i++) {
                this.words[i] = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static French getInstance() {
        if (French.instance == null) {
            French.instance = new French();
        }
        return French.instance;
    }

    public String getWordByIndex(final int index) {
        if ((index >= 0) && (index < this.words.length)) {
            return this.words[index];
        }
        return "";
    }

    public int countWords() {
        return this.words.length;
    }
}

