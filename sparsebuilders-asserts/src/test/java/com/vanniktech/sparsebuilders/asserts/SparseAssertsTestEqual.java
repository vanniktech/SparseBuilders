package com.vanniktech.sparsebuilders.asserts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Date;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
@SuppressWarnings("checkstyle:magicnumber")
public class SparseAssertsTestEqual {
    @Test
    public void testAssertSparseIntArrayEquals() {
        final SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(3, 15);
        sparseIntArray.put(1, 15);

        SparseAsserts.assertSparseIntArrayEquals(sparseIntArray, sparseIntArray);
    }

    @Test
    public void testAssertSparseBooleanArrayEquals() {
        final SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        sparseBooleanArray.put(3, true);
        sparseBooleanArray.put(1, false);

        SparseAsserts.assertSparseBooleanArrayEquals(sparseBooleanArray, sparseBooleanArray);
    }

    @Test
    public void testAssertSparseArrayArrayEquals() {
        final SparseArray<Date> sparseBooleanArray = new SparseArray<>();
        sparseBooleanArray.put(3, new Date(10));
        sparseBooleanArray.put(1, new Date(100));

        SparseAsserts.assertSparseArrayEquals(sparseBooleanArray, sparseBooleanArray);
    }
}
