package com.vanniktech.sparsebuilders;

import android.util.SparseIntArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseIntArrayEquals;

@RunWith(RobolectricTestRunner.class) public class SparseIntArrayBuilderTest {
  @Test public void constructorEmptyBuildShouldReturnEmpty() {
    final SparseIntArray actual = new SparseIntArrayBuilder().build();
    final SparseIntArray expected = new SparseIntArray();

    assertSparseIntArrayEquals(expected, actual);
  }

  @Test public void constructor0CapacityBuildShouldReturnEmpty() {
    final SparseIntArray actual = new SparseIntArrayBuilder(0).build();
    final SparseIntArray expected = new SparseIntArray();

    assertSparseIntArrayEquals(expected, actual);
  }

  @Test public void testConstructorSparseIntArrayShouldNotModifyParameter() {
    final SparseIntArray fromParameter = new SparseIntArrayBuilder().put(23, 1).build();

    new SparseIntArrayBuilder(fromParameter).add(23, 2).put(3, 2).build();

    assertThat(fromParameter.size()).isEqualTo(1);
    assertThat(fromParameter.keyAt(0)).isEqualTo(23);
    assertThat(fromParameter.valueAt(0)).isEqualTo(1);
  }

  @Test public void constructorSparseIntArrayShouldProvideInitialized() {
    final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().put(1, 1).put(2, 2).build();
    final SparseIntArray expectedSparseIntArray = new SparseIntArrayBuilder().put(1, 2).put(2, 2).put(3, 3).build();
    final SparseIntArray fromSparseIntArray = new SparseIntArrayBuilder(sparseIntArray).put(3, 3).add(1, 1).build();

    assertSparseIntArrayEquals(expectedSparseIntArray, fromSparseIntArray);
  }

  @Test public void putShouldPut() {
    final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().put(5, 10).put(8, 2).build();

    assertThat(sparseIntArray.size()).isEqualTo(2);

    assertThat(sparseIntArray.keyAt(0)).isEqualTo(5);
    assertThat(sparseIntArray.valueAt(0)).isEqualTo(10);

    assertThat(sparseIntArray.keyAt(1)).isEqualTo(8);
    assertThat(sparseIntArray.valueAt(1)).isEqualTo(2);
  }

  @Test public void addShouldAdd() {
    final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().add(5, 10).add(5, 2).add(3, 10).build();

    assertThat(sparseIntArray.size()).isEqualTo(2);

    assertThat(sparseIntArray.keyAt(0)).isEqualTo(3);
    assertThat(sparseIntArray.valueAt(0)).isEqualTo(10);

    assertThat(sparseIntArray.keyAt(1)).isEqualTo(5);
    assertThat(sparseIntArray.valueAt(1)).isEqualTo(12);
  }

  @Test public void addSparseIntArrayShouldAdd() {
    final SparseIntArray addedSparseIntArray = new SparseIntArrayBuilder().add(87, 1).add(55, 2).build();
    final SparseIntArray expectedSparseIntArray = new SparseIntArrayBuilder().add(87, 10).put(5, 2).add(55, 35).build();
    final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().add(87, 9)
        .put(5, 2)
        .add(55, 33)
        .add(addedSparseIntArray)
        .build();

    assertSparseIntArrayEquals(expectedSparseIntArray, sparseIntArray);
  }

  @Test public void addNullSparseIntArrayShouldDoNothing() {
    final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().put(0, 0).add(null).build();

    assertThat(sparseIntArray.size()).isEqualTo(1);

    assertThat(sparseIntArray.keyAt(0)).isEqualTo(0);
    assertThat(sparseIntArray.valueAt(0)).isEqualTo(0);
  }

  @Test public void putShouldOverrideAdd() {
    final SparseIntArray sparseIntArray = new SparseIntArrayBuilder().add(5, 10).add(5, 2).put(5, 1).build();

    assertThat(sparseIntArray.size()).isEqualTo(1);

    assertThat(sparseIntArray.keyAt(0)).isEqualTo(5);
    assertThat(sparseIntArray.valueAt(0)).isEqualTo(1);
  }

  @Test public void clear() {
    assertThat(new SparseIntArrayBuilder().put(5, 3).clear().build().size()).isEqualTo(0);
  }
}
