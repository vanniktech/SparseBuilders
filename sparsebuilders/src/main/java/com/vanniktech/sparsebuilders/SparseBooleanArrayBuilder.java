package com.vanniktech.sparsebuilders;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.util.SparseBooleanArray;

public final class SparseBooleanArrayBuilder {
  @NonNull private final SparseBooleanArray sparseBooleanArray;

  /**
   * Constructs empty {@link SparseBooleanArray}
   */
  public SparseBooleanArrayBuilder() {
    sparseBooleanArray = new SparseBooleanArray();
  }

  /**
   * Constructs empty {@link SparseBooleanArray} with given capacity
   */
  public SparseBooleanArrayBuilder(final int capacity) {
    sparseBooleanArray = new SparseBooleanArray(capacity);
  }

  /**
   * Constructs initialized {@link SparseBooleanArray} with given sparseBooleanArray
   *
   * @param sparseBooleanArray sparseBooleanArray
   */
  public SparseBooleanArrayBuilder(@NonNull final SparseBooleanArray sparseBooleanArray) {
    this.sparseBooleanArray = new SparseBooleanArray(sparseBooleanArray.size());

    for (int i = 0; i < sparseBooleanArray.size(); i++) {
      this.sparseBooleanArray.append(sparseBooleanArray.keyAt(i), sparseBooleanArray.valueAt(i));
    }
  }

  /**
   * Puts key and value into {@link SparseBooleanArray}
   *
   * @param key key
   * @param value value
   * @return {@link SparseBooleanArrayBuilder} for chaining
   */
  @CheckResult public SparseBooleanArrayBuilder put(final int key, final boolean value) {
    sparseBooleanArray.put(key, value);
    return this;
  }

  /**
   * Clears the internal {@link SparseBooleanArray}
   *
   * @return {@link SparseBooleanArrayBuilder} for chaining
   */
  @CheckResult public SparseBooleanArrayBuilder clear() {
    sparseBooleanArray.clear();
    return this;
  }

  /**
   * @return built {@link SparseBooleanArray}
   */
  @NonNull @CheckResult public SparseBooleanArray build() {
    return sparseBooleanArray;
  }
}
