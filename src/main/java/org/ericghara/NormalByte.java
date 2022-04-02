package org.ericghara;

class NormalByte extends BruteByte {

    NormalByte(byte[] data, int index) {
        super(data, index);
    }

    void next() throws NullPointerException {
        data[index]++;
        if (data[index] == start) {
            nextByte.next();
        }
    }


}
