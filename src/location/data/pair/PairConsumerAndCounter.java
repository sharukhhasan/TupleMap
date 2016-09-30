package gps.data.pair;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface PairConsumerAndCounter<T> {
    void apply(T value, T value2, int counter);
}
