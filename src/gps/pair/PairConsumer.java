package gps.pair;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface PairConsumer<T> {

    void apply(T value, T value2);
}