package com.vanniktech.sparsebuilders;

import android.util.SparseIntArray;

public class SparseIntArrayBuilder {
    private final SparseIntArray mSparseIntArray;

    /**
     * Constructs empty {@link SparseIntArray}
     */
    public SparseIntArrayBuilder() {
        mSparseIntArray = new SparseIntArray();
    }

    /**
     * Constructs empty {@link SparseIntArray} with given capacity
     */
    public SparseIntArrayBuilder(final int capacity) {
        mSparseIntArray = new SparseIntArray(capacity);
    }

    /**
     * Constructs initialized {@link SparseIntArray} with given sparseIntArray
     *
     * @param sparseIntArray sparseIntArray
     */
    public SparseIntArrayBuilder(final SparseIntArray sparseIntArray) {
        mSparseIntArray = new SparseIntArray(sparseIntArray.size());

        for (int i = 0; i < sparseIntArray.size(); i++) {
            mSparseIntArray.append(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
        }
    }

    /**
     * Puts key and value into {@link SparseIntArray}
     *
     * @param key key
     * @param value value
     * @return {@link SparseIntArrayBuilder} for chaining
     */
    public SparseIntArrayBuilder put(final int key, final int value) {
        mSparseIntArray.put(key, value);
        return this;
    }

    /**
     * Adds present value of key together with the new value and puts it into {@link SparseIntArray}
     *
     * @param key key
     * @param value value
     * @return {@link SparseIntArrayBuilder} for chaining
     */
    public SparseIntArrayBuilder add(final int key, final int value) {
        mSparseIntArray.put(key, mSparseIntArray.get(key, 0) + value);
        return this;
    }

    /**
     * Adds not nullable {@link SparseIntArray} into this one. Values of keys that are present in both {@link SparseIntArray} will be added.
     *
     * @param sparseIntArray sparseIntArray
     * @return {@link SparseIntArrayBuilder} for chaining
     */
    public SparseIntArrayBuilder add(final SparseIntArray sparseIntArray) {
        if (sparseIntArray != null) {
            for (int i = 0; i < sparseIntArray.size(); i++) {
                final int key = sparseIntArray.keyAt(i);
                final int value = sparseIntArray.valueAt(i);

                this.add(key, value);
            }
        }

        return this;
    }

    /**
     * @return built {@link SparseIntArray}
     */
    public SparseIntArray build() {
        return mSparseIntArray;
    }
}
