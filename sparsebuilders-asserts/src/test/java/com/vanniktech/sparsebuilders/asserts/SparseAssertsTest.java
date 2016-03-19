package com.vanniktech.sparsebuilders.asserts;

import org.junit.Test;

import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker;

public class SparseAssertsTest {
    @Test
    public void constructorShouldBePrivate() {
        PrivateConstructorChecker.forClass(SparseAsserts.class).expectedTypeOfException(AssertionError.class).expectedExceptionMessage("No instances.").check();
    }
}
