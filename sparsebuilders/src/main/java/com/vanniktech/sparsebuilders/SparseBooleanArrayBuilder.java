package com.vanniktech.sparsebuilders;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.util.SparseBooleanArray;

public class SparseBooleanArrayBuilder {
    @NonNull private final SparseBooleanArray mSparseBooleanArray;

    /**
     * Constructs empty {@link SparseBooleanArray}
     */
    public SparseBooleanArrayBuilder() {
        mSparseBooleanArray = new SparseBooleanArray();
    }

    /**
     * Constructs empty {@link SparseBooleanArray} with given capacity
     */
    public SparseBooleanArrayBuilder(final int capacity) {
        mSparseBooleanArray = new SparseBooleanArray(capacity);
    }

    /**
     * Constructs initialized {@link SparseBooleanArray} with given sparseBooleanArray
     *
     * @param sparseBooleanArray sparseBooleanArray
     */
    public SparseBooleanArrayBuilder(@NonNull final SparseBooleanArray sparseBooleanArray) {
        mSparseBooleanArray = new SparseBooleanArray(sparseBooleanArray.size());

        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            mSparseBooleanArray.append(sparseBooleanArray.keyAt(i), sparseBooleanArray.valueAt(i));
        }
    }

    /**
     * Puts key and value into {@link SparseBooleanArray}
     *
     * @param key key
     * @param value value
     * @return {@link SparseBooleanArrayBuilder} for chaining
     */
    public SparseBooleanArrayBuilder put(final int key, final boolean value) {
        mSparseBooleanArray.put(key, value);
        return this;
    }

    /**
     * Clears the internal {@link SparseBooleanArray}
     *
     * @return {@link SparseBooleanArrayBuilder} for chaining
     */
    public SparseBooleanArrayBuilder clear() {
        mSparseBooleanArray.clear();
        return this;
    }

    /**
     * @return built {@link SparseBooleanArray}
     */
    @NonNull
    @CheckResult
    public SparseBooleanArray build() {
        return mSparseBooleanArray;
    }
}
