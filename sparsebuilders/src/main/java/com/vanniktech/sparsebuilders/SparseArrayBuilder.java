package com.vanniktech.sparsebuilders;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.util.SparseArray;

public final class SparseArrayBuilder<T> {
  @NonNull private final SparseArray<T> sparseArray;

  /**
   * Constructs an empty {@link SparseArray}
   */
  public SparseArrayBuilder() {
    sparseArray = new SparseArray<>();
  }

  /**
   * Constructs an empty {@link SparseArray} with given capacity
   */
  public SparseArrayBuilder(final int capacity) {
    sparseArray = new SparseArray<>(capacity);
  }

  /**
   * Constructs initialized {@link SparseArray} with given sparseArray
   *
   * @param sparseArray sparseArray
   */
  public SparseArrayBuilder(@NonNull final SparseArray<T> sparseArray) {
    this.sparseArray = new SparseArray<>();

    for (int i = 0; i < sparseArray.size(); i++) {
      this.sparseArray.append(sparseArray.keyAt(i), sparseArray.valueAt(i));
    }
  }

  /**
   * Puts key and value into {@link SparseArray}
   *
   * @param key key
   * @param value value
   * @return {@link SparseArrayBuilder} for chaining
   */
  @CheckResult public SparseArrayBuilder<T> put(final int key, final T value) {
    sparseArray.put(key, value);
    return this;
  }

  /**
   * Clears the internal {@link SparseArray}
   *
   * @return {@link SparseArrayBuilder} for chaining
   */
  @CheckResult public SparseArrayBuilder<T> clear() {
    sparseArray.clear();
    return this;
  }

  /**
   * @return built {@link SparseArray}
   */
  @NonNull @CheckResult public SparseArray<T> build() {
    return sparseArray;
  }
}
