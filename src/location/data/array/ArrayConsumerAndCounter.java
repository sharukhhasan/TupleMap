package gps.data.array;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface ArrayConsumerAndCounter<T> {
    void apply(T[] values, int counter);
}
