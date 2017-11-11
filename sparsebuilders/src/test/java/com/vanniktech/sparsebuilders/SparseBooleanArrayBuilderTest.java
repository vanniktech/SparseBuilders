package com.vanniktech.sparsebuilders;

import android.util.SparseBooleanArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseBooleanArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class) public class SparseBooleanArrayBuilderTest {
  @Test public void constructorEmptyBuildShouldReturnEmpty() {
    final SparseBooleanArray actual = new SparseBooleanArrayBuilder().build();
    final SparseBooleanArray expected = new SparseBooleanArray();

    assertSparseBooleanArrayEquals(expected, actual);
  }

  @Test public void constructor0CapacityBuildShouldReturnEmpty() {
    final SparseBooleanArray actual = new SparseBooleanArrayBuilder(0).build();
    final SparseBooleanArray expected = new SparseBooleanArray();

    assertSparseBooleanArrayEquals(expected, actual);
  }

  @Test public void constructorSparseBooleanArrayShouldProvideInitialized() {
    final SparseBooleanArray sparseBooleanArray = new SparseBooleanArrayBuilder().put(1, false).put(2, true).build();
    final SparseBooleanArray expectedSparseBooleanArray = new SparseBooleanArrayBuilder().put(1, false).put(2, true).put(3, true).build();
    final SparseBooleanArray fromSparseBooleanArray = new SparseBooleanArrayBuilder(sparseBooleanArray).put(3, true).build();

    assertSparseBooleanArrayEquals(expectedSparseBooleanArray, fromSparseBooleanArray);
  }

  @Test public void putShouldPut() {
    final SparseBooleanArray sparseBooleanArray = new SparseBooleanArrayBuilder().put(5, true).put(8, false).build();

    assertEquals(2, sparseBooleanArray.size());

    assertEquals(5, sparseBooleanArray.keyAt(0));
    assertTrue(sparseBooleanArray.valueAt(0));

    assertEquals(8, sparseBooleanArray.keyAt(1));
    assertFalse(sparseBooleanArray.valueAt(1));
  }

  @Test public void clear() {
    assertEquals(0, new SparseBooleanArrayBuilder().put(5, true).clear().build().size());
  }
}
