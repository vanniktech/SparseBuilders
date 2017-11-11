package com.vanniktech.sparsebuilders.asserts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseArrayEquals;
import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseBooleanArrayEquals;
import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseIntArrayEquals;

@RunWith(RobolectricTestRunner.class) public class SparseAssertsNullTest {
  @Rule public final ExpectedException expectedException = ExpectedException.none();

  @Test public void sparseIntArrayEqualsBothNull() {
    assertSparseIntArrayEquals(null, null);
  }

  @Test public void sparseBooleanArrayEqualsBothNull() {
    assertSparseBooleanArrayEquals(null, null);
  }

  @Test public void sparseArrayArrayEqualsBothNull() {
    assertSparseArrayEquals(null, null);
  }

  @Test public void sparseIntArrayEqualsActualNull() {
    expectedException.expect(AssertionError.class);
    expectedException.expectMessage("Expected null but was non null");
    assertSparseIntArrayEquals(null, new SparseIntArray());
  }

  @Test public void sparseBooleanArrayEqualsActualNull() {
    expectedException.expect(AssertionError.class);
    expectedException.expectMessage("Expected null but was non null");
    assertSparseBooleanArrayEquals(null, new SparseBooleanArray());
  }

  @Test public void sparseArrayArrayEqualsActualNull() {
    expectedException.expect(AssertionError.class);
    expectedException.expectMessage("Expected null but was non null");
    assertSparseArrayEquals(null, new SparseArray<>());
  }

  @Test public void sparseIntArrayEqualsExpectedNull() {
    expectedException.expect(AssertionError.class);
    expectedException.expectMessage("Expected non null but was null");
    assertSparseIntArrayEquals(new SparseIntArray(), null);
  }

  @Test public void sparseBooleanArrayEqualsExpectedNull() {
    expectedException.expect(AssertionError.class);
    expectedException.expectMessage("Expected non null but was null");
    assertSparseBooleanArrayEquals(new SparseBooleanArray(), null);
  }

  @Test public void sparseArrayArrayEqualsExpectedNull() {
    expectedException.expect(AssertionError.class);
    expectedException.expectMessage("Expected non null but was null");
    assertSparseArrayEquals(new SparseArray<>(), null);
  }
}
