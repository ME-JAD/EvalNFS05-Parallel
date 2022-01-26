package com.jad;

import com.jad.strongbox.StrongBox;
import com.jad.view.StrongBoxView;

public class Main {
    private static int delayInMilliseconds = 5000;
    private static int nbCodes = 10000000;

    public static void main(String[] args) {
        StrongBox strongBox = new StrongBox(nbCodes);
        StrongBoxView.display(strongBox, delayInMilliseconds);
    }
}
