package com.vanniktech.sparsebuilders;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;

public final class SparseIntArrayBuilder {
  @NonNull private final SparseIntArray sparseIntArray;

  /**
   * Constructs empty {@link SparseIntArray}
   */
  public SparseIntArrayBuilder() {
    sparseIntArray = new SparseIntArray();
  }

  /**
   * Constructs empty {@link SparseIntArray} with given capacity
   */
  public SparseIntArrayBuilder(final int capacity) {
    sparseIntArray = new SparseIntArray(capacity);
  }

  /**
   * Constructs initialized {@link SparseIntArray} with given sparseIntArray
   *
   * @param sparseIntArray sparseIntArray
   */
  public SparseIntArrayBuilder(@NonNull final SparseIntArray sparseIntArray) {
    this.sparseIntArray = new SparseIntArray(sparseIntArray.size());

    for (int i = 0; i < sparseIntArray.size(); i++) {
      this.sparseIntArray.append(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
    }
  }

  /**
   * Puts key and value into {@link SparseIntArray}
   *
   * @param key key
   * @param value value
   * @return {@link SparseIntArrayBuilder} for chaining
   */
  @CheckResult public SparseIntArrayBuilder put(final int key, final int value) {
    sparseIntArray.put(key, value);
    return this;
  }

  /**
   * Adds present value of key together with the new value and puts it into {@link SparseIntArray}
   *
   * @param key key
   * @param value value
   * @return {@link SparseIntArrayBuilder} for chaining
   */
  @CheckResult public SparseIntArrayBuilder add(final int key, final int value) {
    sparseIntArray.put(key, sparseIntArray.get(key, 0) + value);
    return this;
  }

  /**
   * Adds not nullable {@link SparseIntArray} into this one. Values of keys that are present in both
   * {@link SparseIntArray} will be added.
   *
   * @param array array
   * @return {@link SparseIntArrayBuilder} for chaining
   */
  @CheckResult public SparseIntArrayBuilder add(@Nullable final SparseIntArray array) {
    if (array != null) {
      for (int i = 0; i < array.size(); i++) {
        final int key = array.keyAt(i);
        final int value = array.valueAt(i);

        //noinspection AndroidLintCheckResult
        add(key, value);
      }
    }

    return this;
  }

  /**
   * Clears the internal {@link SparseIntArray}
   *
   * @return {@link SparseIntArrayBuilder} for chaining
   */
  @CheckResult public SparseIntArrayBuilder clear() {
    sparseIntArray.clear();
    return this;
  }

  /**
   * @return built {@link SparseIntArray}
   */
  @NonNull @CheckResult public SparseIntArray build() {
    return sparseIntArray;
  }
}
