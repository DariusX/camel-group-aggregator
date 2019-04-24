package com.zerses.util;

/**
 * For use with the GroupedRecordAggregator
 * The POJO being grouped should implement this method
 *
 * @param <T>
 */
public interface GroupedRecord<T> {

    /**
     * Returns the  value that should be as an identifier for the group.
     * This can be a simple String, or any other Object on which an equals() method will work correctly
     *
     * @return
     */
    T getGroupKey();
}
