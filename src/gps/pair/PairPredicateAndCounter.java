package gps.pair;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface PairPredicateAndCounter<T> {
    boolean test(T t1, T t2, int counter);
}