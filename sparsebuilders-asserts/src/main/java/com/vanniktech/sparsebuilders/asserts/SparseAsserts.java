package com.vanniktech.sparsebuilders.asserts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

import org.junit.Assert;

public final class SparseAsserts {
    private SparseAsserts() {
        throw new AssertionError("No instances.");
    }

    /**
     * Asserts that {@link SparseIntArray} are equal. Equal is defined as same sizes. Plus same keys and values at each index.
     *
     * @param expected expected SparseIntArray
     * @param actual actual SparseIntArray
     */
    public static void assertSparseIntArrayEquals(final SparseIntArray expected, final SparseIntArray actual) {
        assertSizesEqual(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            final int expectedKey = expected.keyAt(i);
            final int actualKey = actual.keyAt(i);

            assertKeysEqual(i, expectedKey, actualKey);

            final int expectedValue = expected.valueAt(i);
            final int actualValue = actual.valueAt(i);

            assertValuesEqual(i, expectedValue, actualValue);
        }
    }

    /**
     * Asserts that {@link SparseBooleanArray} are equal. Equal is defined as same sizes. Plus same keys and values at each index.
     *
     * @param expected expected SparseBooleanArray
     * @param actual actual SparseBooleanArray
     */
    public static void assertSparseBooleanArrayEquals(final SparseBooleanArray expected, final SparseBooleanArray actual) {
        assertSizesEqual(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            final int expectedKey = expected.keyAt(i);
            final int actualKey = actual.keyAt(i);

            assertKeysEqual(i, expectedKey, actualKey);

            final boolean expectedValue = expected.valueAt(i);
            final boolean actualValue = actual.valueAt(i);

            assertValuesEqual(i, expectedValue, actualValue);
        }
    }

    /**
     * Asserts that {@link SparseArray} are equal. Equal is defined as same sizes. Plus same keys and values at each index.
     *
     * @param expected expected SparseBooleanArray
     * @param actual actual SparseBooleanArray
     */
    public static <T> void assertSparseArrayEquals(final SparseArray<T> expected, final SparseArray<T> actual) {
        assertSizesEqual(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            final int expectedKey = expected.keyAt(i);
            final int actualKey = actual.keyAt(i);

            assertKeysEqual(i, expectedKey, actualKey);

            final T expectedValue = expected.valueAt(i);
            final T actualValue = actual.valueAt(i);

            assertValuesEqual(i, expectedValue, actualValue);
        }
    }

    private static void assertKeysEqual(final int i, final int expectedKey, final int actualKey) {
        Assert.assertEquals("Key at index " + i + " does not match", expectedKey, actualKey);
    }

    private static void assertSizesEqual(final int expectedSize, final int actualSize) {
        Assert.assertEquals("Size does not match", expectedSize, actualSize);
    }

    private static <T> void assertValuesEqual(final int i, final T expectedValue, final T actualValue) {
        Assert.assertEquals("Value at index " + i + " does not match.", expectedValue, actualValue);
    }
}
