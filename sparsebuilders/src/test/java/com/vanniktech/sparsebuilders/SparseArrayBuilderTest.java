package com.vanniktech.sparsebuilders;

import android.util.SparseArray;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseArrayEquals;

@RunWith(RobolectricTestRunner.class) public class SparseArrayBuilderTest {
  @Test public void constructorEmptyBuildShouldReturnEmpty() {
    final SparseArray<String> actual = new SparseArrayBuilder<String>().build();
    final SparseArray<String> expected = new SparseArray<>();

    assertSparseArrayEquals(expected, actual);
  }

  @Test public void constructor0CapacityBuildShouldReturnEmpty() {
    final SparseArray<String> actual = new SparseArrayBuilder<String>(0).build();
    final SparseArray<String> expected = new SparseArray<>();

    assertSparseArrayEquals(expected, actual);
  }

  @Test public void testConstructorValueShouldNotModifyParameter() {
    final Date first = new Date(1);

    final SparseArray<Date> fromParameter = new SparseArrayBuilder<Date>().put(340, first).build();

    new SparseArrayBuilder<>(fromParameter).put(3, new Date(1)).build();

    assertThat(fromParameter.size()).isEqualTo(1);
    assertThat(fromParameter.keyAt(0)).isEqualTo(340);
    assertThat(fromParameter.valueAt(0).getTime()).isEqualTo(1);
  }

  @Test public void constructorSparseArrayShouldProvideInitialized() {
    final Date first = new Date(43);
    final Date second = new Date(39);
    final Date third = new Date(8);

    final SparseArray<Date> sparseArray = new SparseArrayBuilder<Date>().put(1, first).put(2, second).build();
    final SparseArray<Date> expectedSparseArray = new SparseArrayBuilder<Date>().put(1, first).put(2, second).put(3, third).build();

    final SparseArray<Date> fromSparseArray = new SparseArrayBuilder<>(sparseArray).put(3, third).build();

    assertSparseArrayEquals(expectedSparseArray, fromSparseArray);
  }

  @Test public void putShouldPut() {
    final Date first = new Date(5);
    final Date second = new Date(2);
    final SparseArray<Date> sparseArray = new SparseArrayBuilder<Date>().put(5, first).put(8, second).build();

    assertThat(sparseArray.size()).isEqualTo(2);

    assertThat(sparseArray.keyAt(0)).isEqualTo(5);
    assertThat(sparseArray.valueAt(0)).isEqualTo(first);

    assertThat(sparseArray.keyAt(1)).isEqualTo(8);
    assertThat(sparseArray.valueAt(1)).isEqualTo(second);
  }

  @Test public void clear() {
    assertThat(new SparseArrayBuilder<Integer>().put(5, 3).clear().build().size()).isEqualTo(0);
  }
}
