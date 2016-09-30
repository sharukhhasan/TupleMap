package gps.array;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface ArrayPredicateAndCounter<T> {

    boolean test(T[] values, int counter);

}