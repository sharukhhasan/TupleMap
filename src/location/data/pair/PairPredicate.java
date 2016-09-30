package gps.data.pair;

/**
 * Created by sharukhhasan on 9/30/16.
 */
@FunctionalInterface
public interface PairPredicate<T> {
    boolean test(T t1, T t2);
}
