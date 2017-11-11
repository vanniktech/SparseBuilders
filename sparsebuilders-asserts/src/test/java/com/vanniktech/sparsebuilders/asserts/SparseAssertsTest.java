package com.vanniktech.sparsebuilders.asserts;

import com.pushtorefresh.private_constructor_checker.PrivateConstructorChecker;
import org.junit.Test;

public class SparseAssertsTest {
  @Test public void constructorShouldBePrivate() {
    PrivateConstructorChecker.forClass(SparseAsserts.class)
        .expectedTypeOfException(AssertionError.class)
        .expectedExceptionMessage("No instances.")
        .check();
  }
}
