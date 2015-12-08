package com.vanniktech.sparsebuilders;

import android.util.SparseArray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Date;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import static com.vanniktech.sparsebuilders.asserts.SparseAsserts.assertSparseArrayEquals;
import static org.junit.Assert.assertEquals;

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
@SuppressWarnings("checkstyle:magicnumber")
public class SparseArrayBuilderTest {
    @Test
    public void testConstructorEmptyBuildShouldReturnEmpty() {
        final SparseArray<String> actual = new SparseArrayBuilder<String>().build();
        final SparseArray<String> expected = new SparseArray<>();

        assertSparseArrayEquals(expected, actual);
    }

    @Test
    public void testConstructor0CapacityBuildShouldReturnEmpty() {
        final SparseArray<String> actual = new SparseArrayBuilder<String>(0).build();
        final SparseArray<String> expected = new SparseArray<>();

        assertSparseArrayEquals(expected, actual);
    }

    @Test
    @SuppressFBWarnings(value = "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", justification = "Just a test")
    public void testConstructorValueShouldNotModifyParameter() {
        final Date first = new Date(1);

        final SparseArray<Date> fromParameter = new SparseArrayBuilder<Date>().put(340, first).build();

        // noinspection ResourceType
        new SparseArrayBuilder<>(fromParameter).put(3, new Date(1)).build();

        assertEquals(1, fromParameter.size());
        assertEquals(340, fromParameter.keyAt(0));
        assertEquals(1, fromParameter.valueAt(0).getTime());
    }

    @Test
    public void testConstructorSparseArrayShouldProvideInitialized() {
        final Date first = new Date(43);
        final Date second = new Date(39);
        final Date third = new Date(8);

        final SparseArray<Date> sparseArray = new SparseArrayBuilder<Date>().put(1, first).put(2, second).build();
        final SparseArray<Date> expectedSparseArray = new SparseArrayBuilder<Date>().put(1, first).put(2, second).put(3, third).build();

        final SparseArray<Date> fromSparseArray = new SparseArrayBuilder<>(sparseArray).put(3, third).build();

        assertSparseArrayEquals(expectedSparseArray, fromSparseArray);
    }

    @Test
    public void testPutShouldPut() {
        final Date first = new Date(5);
        final Date second = new Date(2);
        final SparseArray<Date> sparseArray = new SparseArrayBuilder<Date>().put(5, first).put(8, second).build();

        assertEquals(2, sparseArray.size());

        assertEquals(5, sparseArray.keyAt(0));
        assertEquals(first, sparseArray.valueAt(0));

        assertEquals(8, sparseArray.keyAt(1));
        assertEquals(second, sparseArray.valueAt(1));
    }
}
