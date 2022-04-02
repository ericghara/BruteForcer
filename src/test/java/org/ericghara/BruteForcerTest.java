package org.ericghara;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BruteForcerTest {

    Random rand = new Random();

    // test requires ~15 sec;
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void BruteForcerCracksCode(int bytes) {
        byte[] code = new byte[bytes];
        for (int i = 0; i < bytes; i++) {
            code[i] = (byte) rand.nextInt();
        }
        var brute = new BruteForcer(bytes);
        byte[] perm = brute.getSequence();
        Supplier<Boolean> test = () -> {
            while (!Arrays.equals(code, perm) )  {
                brute.nextPermutation();
            }
            return true;
        };
        assertTrue(test.get());
    }

    @Test
    void BruteForceThrowsWhenNoMatchPossible() {
        var brute = new BruteForcer(3);
        Supplier<Boolean> test = () -> {
            while (true)  {
                brute.nextPermutation();
            }
        };
        assertThrows(NoMorePermutationsException.class, test::get);
    }

    @Test
    void BruteForceThrowsWhenNumBytesLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> new BruteForcer(0));
    }
}