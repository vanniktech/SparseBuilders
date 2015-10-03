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

import java.util.Date;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class SparseAssertsTestKey {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAssertSparseIntArrayEquals() {
        final SparseIntArray first = new SparseIntArray();
        first.put(1, 15);
        first.put(3, 15);

        final SparseIntArray second = new SparseIntArray();
        second.put(3, 15);
        second.put(5, 15);

        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Key at index 0 does not match");
        SparseAsserts.assertSparseIntArrayEquals(first, second);
    }

    @Test
    public void testAssertSparseBooleanArrayEquals() {
        final SparseBooleanArray first = new SparseBooleanArray();
        first.put(1, false);
        first.put(3, true);

        final SparseBooleanArray second = new SparseBooleanArray();
        second.put(0, true);
        second.put(1, true);

        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Key at index 0 does not match");
        SparseAsserts.assertSparseBooleanArrayEquals(first, second);
    }

    @Test
    public void testAssertSparseArrayArrayEquals() {
        final SparseArray<Date> first = new SparseArray<>();
        first.put(4, new Date(100));
        first.put(3, new Date(10));

        final SparseArray<Date> second = new SparseArray<>();
        second.put(5, new Date(10));
        second.put(3, new Date(10));

        expectedException.expect(AssertionError.class);
        expectedException.expectMessage("Key at index 1 does not match");
        SparseAsserts.assertSparseArrayEquals(first, second);
    }
}
