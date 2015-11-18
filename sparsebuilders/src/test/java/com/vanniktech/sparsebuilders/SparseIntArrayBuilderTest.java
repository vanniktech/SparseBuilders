package com.vanniktech.sparsebuilders;

import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseIntArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import android.util.SparseIntArray;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class SparseIntArrayBuilderTest {
    @Test
    public void testConstructorEmptyBuildShouldReturnEmpty() {
        final SparseIntArray actual = new SparseIntArrayBuilder().build();
        final SparseIntArray expected = new SparseIntArray();

        assertSparseIntArrayEquals(expected, actual);
    }

    @Test
    public void testConstructor0CapacityBuildShouldReturnEmpty() {
        final SparseIntArray actual = new SparseIntArrayBuilder(0).build();
        final SparseIntArray expected = new SparseIntArray();

        assertSparseIntArrayEquals(expected, actual);
    }

    @Test
    public void testConstructorSparseIntArrayShouldNotModifyParameter() {
        final SparseIntArray fromParameter = new SparseIntArrayBuilder().put(23, 1).build();

        // noinspection ResourceType
        new SparseIntArrayBuilder(fromParameter).add(23, 2).put(3, 2).build();

        assertEquals(1, fromParameter.size());
        assertEquals(23, fromParameter.keyAt(0));
        assertEquals(1, fromParameter.valueAt(0));
    }

    @Test
    public void testConstructorSparseIntArrayShouldProvideInitialized() {
        final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().put(1, 1).put(2, 2).build();
        final SparseIntArray expectedSparseIntArray = new SparseIntArrayBuilder().put(1, 2).put(2, 2).put(3, 3).build();
        final SparseIntArray fromSparseIntArray = new SparseIntArrayBuilder(sparseIntArray).put(3, 3).add(1, 1).build();

        assertSparseIntArrayEquals(expectedSparseIntArray, fromSparseIntArray);
    }

    @Test
    public void testPutShouldPut() {
        final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().put(5, 10).put(8, 2).build();

        assertEquals(2, sparseIntArray.size());

        assertEquals(5, sparseIntArray.keyAt(0));
        assertEquals(10, sparseIntArray.valueAt(0));

        assertEquals(8, sparseIntArray.keyAt(1));
        assertEquals(2, sparseIntArray.valueAt(1));
    }

    @Test
    public void testAddShouldAdd() {
        final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().add(5, 10).add(5, 2).add(3, 10).build();

        assertEquals(2, sparseIntArray.size());

        assertEquals(3, sparseIntArray.keyAt(0));
        assertEquals(10, sparseIntArray.valueAt(0));

        assertEquals(5, sparseIntArray.keyAt(1));
        assertEquals(12, sparseIntArray.valueAt(1));
    }

    @Test
    public void testAddSparseIntArrayShouldAdd() {
        final SparseIntArray addedSparseIntArray = new SparseIntArrayBuilder().add(87, 1).add(55, 2).build();
        final SparseIntArray expectedSparseIntArray = new SparseIntArrayBuilder().add(87, 10).put(5, 2).add(55, 35).build();
        final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().add(87, 9).put(5, 2).add(55, 33).add(addedSparseIntArray).build();

        assertSparseIntArrayEquals(expectedSparseIntArray, sparseIntArray);
    }

    @Test
    public void testAddNullSparseIntArrayShouldDoNothing() {
        final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().put(0, 0).add(null).build();

        assertEquals(1, sparseIntArray.size());

        assertEquals(0, sparseIntArray.keyAt(0));
        assertEquals(0, sparseIntArray.valueAt(0));
    }

    @Test
    public void testPutShouldOverrideAdd() {
        final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().add(5, 10).add(5, 2).put(5, 1).build();

        assertEquals(1, sparseIntArray.size());

        assertEquals(5, sparseIntArray.keyAt(0));
        assertEquals(1, sparseIntArray.valueAt(0));
    }
}
