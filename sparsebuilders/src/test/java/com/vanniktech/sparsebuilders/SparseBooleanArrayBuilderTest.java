package com.vanniktech.sparsebuilders;

import android.util.SparseBooleanArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseBooleanArrayEquals;

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

    assertThat(sparseBooleanArray.size()).isEqualTo(2);

    assertThat(sparseBooleanArray.keyAt(0)).isEqualTo(5);
    assertThat(sparseBooleanArray.valueAt(0)).isTrue();

    assertThat(sparseBooleanArray.keyAt(1)).isEqualTo(8);
    assertThat(sparseBooleanArray.valueAt(1)).isFalse();
  }

  @Test public void clear() {
    assertThat(new SparseBooleanArrayBuilder().put(5, true).clear().build().size()).isEqualTo(0);
  }
}
