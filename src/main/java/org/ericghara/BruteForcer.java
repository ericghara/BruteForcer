package org.ericghara;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BruteForcer {

    private final int numBytes;
    private final byte[] sequence;
    private final BruteByte bytes;

    /**
     * Constructs a {@code BruteForcer} object creating
     * {@code numByte} length permutations;
     * @param numBytes byte length of permutations
     * @throws IllegalArgumentException when {@code numbytes} <= 0;
     */
    public BruteForcer(int numBytes) throws IllegalArgumentException {
        this.numBytes = validate(numBytes);
        this.sequence = new byte[numBytes];
        this.bytes = initBytes();
    }

    /**
     * Returns a reference to the permutation sequence.
     * This is updated with each call to {@link BruteForcer#nextPermutation()}.
     * This reference is mutable and modification of the {@code byte[]} will modify the state of
     * {@code BruteForcer}.  This is a very costly compromise that was made to reduce the
     * computation time for creating permutations.
     *
     * @return {@code byte[]} mutable reference to sequences.
     */
    public byte[] getSequence() {
        return sequence;
    }

    /**
     * Updates {@code data} (accessed via {@link BruteForcer#getSequence()}) with
     * a new permutation if available.
     * @throws NoMorePermutationsException when no unique permutations are available.  This prevents infinite
     * loops.
     */
    public void nextPermutation() throws NoMorePermutationsException {
        bytes.next();
    }

    int validate(int numBytes) throws IllegalArgumentException {
        if (numBytes <= 0) {
            throw new IllegalArgumentException("Num bytes must be greater than 0.");
        }
        return numBytes;
    }

    BruteByte initBytes() {
        final BruteByte first = new NormalByte(sequence, 0);
        BruteByte last =  first;
        for (int i = 1; i < numBytes; i++) {
            BruteByte cur;
            if (i < numBytes-1) {
                cur = new NormalByte(sequence, i);
            } else {  // last byte
                cur = new MostSignificantByte(sequence);
            }
            last.setNextByte(cur);
            last = cur;
        }
        return first;
    }

    /**
     * A simple CLI demo that <em>brute forces</em>
     * an input code, specified by {@code args};
     * @param args the code to brute force separated by spaces.  The code
     * must be numbers from -128 to 127 inclusive.
     */
    public static void main (String[] args) throws NumberFormatException {
        final byte[] code = new byte[args.length];
        IntStream.range(0, args.length)
                 .forEach( i ->
                         code[i] = Byte.parseByte(args[i]));
        var brute = new BruteForcer(code.length);
        var seq = brute.getSequence();
        while (!Arrays.equals(code, seq) )  {
            brute.nextPermutation();
        }
        System.out.printf("Your code was: %s%n", Arrays.toString(seq) );
    }
}
