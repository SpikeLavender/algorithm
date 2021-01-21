package com.natsumes.redis;

import java.util.Arrays;

/**
 * 位图 bitmap
 *
 * 去重，交集，并集，判断存在与否
 * 非集（与全集异或）
 *
 * @author hetengjiao
 */
public class Bitmap {

    private static final int ADDRESS_BITS_PER_WORD = 6;

    private static final int BITS_PER_WORD = 1 << ADDRESS_BITS_PER_WORD;

    private long[] words;

    private transient int wordsInUse = 0;

    private static int wordIndex(int bitIndex) {
        return bitIndex >> ADDRESS_BITS_PER_WORD;
    }

    public Bitmap() {
        initWords(BITS_PER_WORD);
    }

    /**
     *
     * @param nbits total bit num
     */
    public Bitmap(int nbits) {
        if (nbits < 0) {
            throw new NegativeArraySizeException("nbits < 0: " + nbits);
        }
        initWords(nbits);
    }

    private void initWords(int nbits) {
        words = new long[wordIndex(nbits - 1) + 1];
    }

    public void set(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }

        int wordIndex = wordIndex(bitIndex);
        expandTo(wordIndex);
        words[wordIndex] = (1L << bitIndex);
        checkInvariants();
    }

    public boolean get(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }
        checkInvariants();
        int wordIndex = wordIndex(bitIndex);
        return (wordIndex < wordsInUse) && ((words[wordIndex] & (1L << bitIndex)) != 0);
    }

    public void clear(int bitIndex) {
        if (bitIndex < 0) {
            throw new IndexOutOfBoundsException("bitIndex < 0: " + bitIndex);
        }

        int wordIndex = wordIndex(bitIndex);
        if (wordIndex >= wordsInUse) {
            return;
        }

        words[wordIndex] &= ~(1L << bitIndex);

        recalculateWordsInUse();
        checkInvariants();
    }

    private void recalculateWordsInUse() {
        int i;
        for (i = wordsInUse - 1; i >= 0; i--) {
            if (words[i] != 0) {
                break;
            }
        }
        wordsInUse = i + 1;
    }

    private void checkInvariants() {
        assert(wordsInUse == 0 || words[wordsInUse - 1] != 0);
        assert(wordsInUse <= words.length);
        assert(wordsInUse == words.length || words[wordsInUse] == 0);
    }

    private void expandTo(int wordIndex) {
        int wordsRequired = wordIndex + 1;
        if (wordsInUse < wordsRequired) {
            ensureCapacity(wordsRequired);
            wordsInUse = wordsRequired;
        }
    }

    private void ensureCapacity(int wordsRequired) {
        if (words.length < wordsRequired) {
            int request = Math.max(2 * words.length, wordsRequired);
            words = Arrays.copyOf(words, request);
        }
    }
}