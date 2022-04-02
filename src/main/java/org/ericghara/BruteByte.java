package org.ericghara;

import java.util.Objects;
import java.util.SplittableRandom;

abstract class BruteByte {

    BruteByte nextByte;
    final byte[] data;
    final int index;
    final byte start;

    BruteByte(byte[] data, int index) {
        this.data = data;
        this.index = index;
        this.start = (byte) new SplittableRandom().nextLong();
        data[index] = start;
    }

    void setNextByte(BruteByte next) {
        if (Objects.nonNull(nextByte) ) {
            throw new IllegalStateException("Next byte already set.");
        }
        this.nextByte = next;
    }

    abstract void next() throws NullPointerException, NoMorePermutationsException;

}
