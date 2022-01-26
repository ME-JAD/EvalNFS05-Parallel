package com.jad.view;

import com.jad.strongbox.State;
import com.jad.strongbox.StrongBox;

public final class StrongBoxView implements Runnable {
    private final StrongBox strongBox;
    private final int delayInMilliseconds;

    private StrongBoxView(final StrongBox strongBox, final int delayInMilliseconds) {
        this.strongBox = strongBox;
        this.delayInMilliseconds = delayInMilliseconds;
    }

    public static void display(final StrongBox strongBox, int delayInMilliseconds) {
        Thread thread = new Thread(new StrongBoxView(strongBox, delayInMilliseconds));
        thread.start();
    }

    private void printStrongBox() {
        int nbOpenedCodes = 0;
        for (int codeIndex = 0; codeIndex < this.strongBox.countCodes(); codeIndex++) {
            if (this.strongBox.getStateFromCodeByIndex(codeIndex) == State.Open) {
                nbOpenedCodes++;
            }
        }
        System.out.println("StrongBox : [" + nbOpenedCodes + "] opened - [" + (this.strongBox.countCodes() - nbOpenedCodes) + "] closed");
    }

    @Override
    public void run() {
        while(this.strongBox.getState() != State.Open) {
            this.printStrongBox();
            try {
                Thread.sleep(this.delayInMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
