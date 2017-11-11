package com.vanniktech.sparsebuilders.asserts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseArrayEquals;
import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseBooleanArrayEquals;
import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseIntArrayEquals;

@RunWith(RobolectricTestRunner.class) public class SparseAssertsEqualTest {
  @Test public void sparseIntArrayEquals() {
    final SparseIntArray sparseIntArray = new SparseIntArray();
    sparseIntArray.put(3, 15);
    sparseIntArray.put(1, 15);

    assertSparseIntArrayEquals(sparseIntArray, sparseIntArray);
  }

  @Test public void sparseBooleanArrayEquals() {
    final SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
    sparseBooleanArray.put(3, true);
    sparseBooleanArray.put(1, false);

    assertSparseBooleanArrayEquals(sparseBooleanArray, sparseBooleanArray);
  }

  @Test public void sparseArrayEquals() {
    final SparseArray<Date> sparseBooleanArray = new SparseArray<>();
    sparseBooleanArray.put(3, new Date(10));
    sparseBooleanArray.put(1, new Date(100));

    assertSparseArrayEquals(sparseBooleanArray, sparseBooleanArray);
  }
}
