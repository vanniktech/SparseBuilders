package com.vanniktech.sparsebuilders.asserts;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

import org.junit.Assert;

public final class SparseAsserts {
    private SparseAsserts() {
        throw new AssertionError("No instances.");
    }

    /**
     * Asserts that {@link SparseIntArray} are equal. Equal is defined either as same sizes, same keys and values at each index or if both are null.
     *
     * @param expected expected SparseIntArray
     * @param actual actual SparseIntArray
     */
    public static void assertSparseIntArrayEquals(@Nullable final SparseIntArray expected, @Nullable final SparseIntArray actual) {
        if (!SparseAsserts.assertNullability(expected, actual)) {
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
    }

    /**
     * Asserts that {@link SparseBooleanArray} are equal. Equal is defined either as same sizes, same keys and values at each index or if both are null.
     *
     * @param expected expected SparseBooleanArray
     * @param actual actual SparseBooleanArray
     */
    public static void assertSparseBooleanArrayEquals(@Nullable final SparseBooleanArray expected, @Nullable final SparseBooleanArray actual) {
        if (!SparseAsserts.assertNullability(expected, actual)) {
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
    }

    /**
     * Asserts that {@link SparseArray} are equal. Equal is defined either as same sizes, same keys and values at each index or if both are null.
     *
     * @param expected expected SparseArray
     * @param actual actual SparseArray
     * @param <T> dynamic type t
     */
    public static <T> void assertSparseArrayEquals(@Nullable final SparseArray<T> expected, @Nullable final SparseArray<T> actual) {
        if (!SparseAsserts.assertNullability(expected, actual)) {
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

    private static boolean assertNullability(final Object expected, final Object actual) {
        if (expected == null) {
            assertNull("Expected null but was non null", actual);
            return true;
        }

        assertNotNull("Expected non null but was null", actual);
        return false;
    }
}
