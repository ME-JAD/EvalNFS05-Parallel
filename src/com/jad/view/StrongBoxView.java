package com.jad.view;

import com.jad.strongbox.State;
import com.jad.strongbox.StrongBox;

/**
 * The type Strong box view.
 */
public final class StrongBoxView implements Runnable {
    private final StrongBox strongBox;
    private final int delayInMilliseconds;

    private StrongBoxView(final StrongBox strongBox, final int delayInMilliseconds) {
        this.strongBox = strongBox;
        this.delayInMilliseconds = delayInMilliseconds;
    }

    /**
     * Display the count of opened, closed and locked codes.
     *
     * @param strongBox           the strong box
     * @param delayInMilliseconds the delay in milliseconds
     */
    public static void display(final StrongBox strongBox, int delayInMilliseconds) {
        Thread thread = new Thread(new StrongBoxView(strongBox, delayInMilliseconds));
        thread.start();
    }

    private void printStrongBox() {
        int nbOpenedCodes = 0;
        int nbClosedCodes = 0;
        for (int codeIndex = 0; codeIndex < this.strongBox.countCodes(); codeIndex++) {
            switch (this.strongBox.getStateFromCodeByIndex(codeIndex)) {
                case Open:
                    nbOpenedCodes++;
                    break;
                case Close:
                    nbClosedCodes++;
                    break;
            }
        }
        System.out.println("StrongBox : [" + nbOpenedCodes + "] opened - [" +
                nbClosedCodes + "] closed - [" +
                (this.strongBox.countCodes() - nbOpenedCodes - nbClosedCodes) + "] locked");
    }

    @Override
    public void run() {
        while (this.strongBox.getState() != State.Open) {
            this.printStrongBox();
            try {
                Thread.sleep(this.delayInMilliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.printStrongBox();
    }
}
