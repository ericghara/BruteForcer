package org.ericghara;

public class MostSignificantByte extends BruteByte {

    MostSignificantByte(byte[] data) {
        super(data, data.length-1);
    }

    void next() throws NoMorePermutationsException {
        data[index]++;
        if (data[index] == start) {
            throw new NoMorePermutationsException();
        }
    }
}
