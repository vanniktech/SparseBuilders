package com.vanniktech.sparsebuilders.asserts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class SparseAssertsTestNull {
    @Rule public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAssertSparseIntArrayEqualsBothNull() {
        SparseAsserts.assertSparseIntArrayEquals(null, null);
    }

    @Test
    public void testAssertSparseBooleanArrayEqualsBothNull() {
        SparseAsserts.assertSparseBooleanArrayEquals(null, null);
    }

    @Test
    public void testAssertSparseArrayArrayEqualsBothNull() {
        SparseAsserts.assertSparseArrayEquals(null, null);
    }

    @Test
    public void testAssertSparseIntArrayEqualsActualNull() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Expected null but was non null");
        SparseAsserts.assertSparseIntArrayEquals(null, new SparseIntArray());
    }

    @Test
    public void testAssertSparseBooleanArrayEqualsActualNull() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Expected null but was non null");
        SparseAsserts.assertSparseBooleanArrayEquals(null, new SparseBooleanArray());
    }

    @Test
    public void testAssertSparseArrayArrayEqualsActualNull() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Expected null but was non null");
        SparseAsserts.assertSparseArrayEquals(null, new SparseArray<>());
    }

    @Test
    public void testAssertSparseIntArrayEqualsExpectedNull() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Expected non null but was null");
        SparseAsserts.assertSparseIntArrayEquals(new SparseIntArray(), null);
    }

    @Test
    public void testAssertSparseBooleanArrayEqualsExpectedNull() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Expected non null but was null");
        SparseAsserts.assertSparseBooleanArrayEquals(new SparseBooleanArray(), null);
    }

    @Test
    public void testAssertSparseArrayArrayEqualsExpectedNull() {
        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Expected non null but was null");
        SparseAsserts.assertSparseArrayEquals(new SparseArray<>(), null);
    }
}
