package com.vanniktech.sparsebuilders;

import android.support.annotation.CheckResult;
import android.util.SparseArray;

public class SparseArrayBuilder<T> {
    private final SparseArray<T> mSparseArray;

    /**
     * Constructs empty {@link SparseArray}
     */
    public SparseArrayBuilder() {
        mSparseArray = new SparseArray<>();
    }

    /**
     * Constructs empty {@link SparseArray} with given capacity
     */
    public SparseArrayBuilder(final int capacity) {
        mSparseArray = new SparseArray<>(capacity);
    }

    /**
     * Constructs initialized {@link SparseArray} with given sparseArray
     * 
     * @param sparseArray sparseArray
     */
    public SparseArrayBuilder(final SparseArray<T> sparseArray) {
        mSparseArray = new SparseArray<>();

        for (int i = 0; i < sparseArray.size(); i++) {
            mSparseArray.append(sparseArray.keyAt(i), sparseArray.valueAt(i));
        }
    }

    /**
     * Puts key and value into {@link SparseArray}
     * 
     * @param key key
     * @param value value
     * @return {@link SparseArrayBuilder} for chaining
     */
    public SparseArrayBuilder<T> put(final int key, final T value) {
        mSparseArray.put(key, value);
        return this;
    }

    /**
     * @return built {@link SparseArray}
     */
    @CheckResult
    public SparseArray<T> build() {
        return mSparseArray;
    }
}
