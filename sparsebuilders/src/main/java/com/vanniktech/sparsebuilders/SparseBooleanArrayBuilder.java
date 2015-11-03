package com.vanniktech.sparsebuilders;

import android.util.SparseBooleanArray;

public class SparseBooleanArrayBuilder {
    private final SparseBooleanArray mSparseBooleanArray;

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
    public SparseBooleanArrayBuilder(final SparseBooleanArray sparseBooleanArray) {
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
     * @return built {@link SparseBooleanArray}
     */
    public SparseBooleanArray build() {
        return mSparseBooleanArray;
    }
}
