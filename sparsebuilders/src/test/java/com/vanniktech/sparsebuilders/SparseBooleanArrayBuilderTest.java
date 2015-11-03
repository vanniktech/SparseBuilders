package com.vanniktech.sparsebuilders;

import android.util.SparseBooleanArray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseBooleanArrayEquals;
import static org.junit.Assert.assertEquals;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class SparseBooleanArrayBuilderTest {
    @Test
    public void testConstructorEmptyBuildShouldReturnEmpty() {
        final SparseBooleanArray actual = new SparseBooleanArrayBuilder().build();
        final SparseBooleanArray expected = new SparseBooleanArray();

        assertSparseBooleanArrayEquals(expected, actual);
    }

    @Test
    public void testConstructor0CapacityBuildShouldReturnEmpty() {
        final SparseBooleanArray actual = new SparseBooleanArrayBuilder().build();
        final SparseBooleanArray expected = new SparseBooleanArray();

        assertSparseBooleanArrayEquals(expected, actual);
    }

    @Test
    public void testConstructorSparseBooleanArrayShouldProvideInitialized() {
        final SparseBooleanArray sparseBooleanArray = new SparseBooleanArrayBuilder().put(1, false).put(2, true).build();
        final SparseBooleanArray expectedSparseBooleanArray = new SparseBooleanArrayBuilder().put(1, false).put(2, true).put(3, true).build();
        final SparseBooleanArray fromSparseBooleanArray = new SparseBooleanArrayBuilder(sparseBooleanArray).put(3, true).build();

        assertSparseBooleanArrayEquals(expectedSparseBooleanArray, fromSparseBooleanArray);
    }

    @Test
    public void testPutShouldPut() {
        final SparseBooleanArray sparseBooleanArray = new SparseBooleanArrayBuilder().put(5, true).put(8, false).build();

        assertEquals(2, sparseBooleanArray.size());

        assertEquals(5, sparseBooleanArray.keyAt(0));
        assertEquals(true, sparseBooleanArray.valueAt(0));

        assertEquals(8, sparseBooleanArray.keyAt(1));
        assertEquals(false, sparseBooleanArray.valueAt(1));
    }
}
