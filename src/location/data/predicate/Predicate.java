package gps.data.predicate;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}