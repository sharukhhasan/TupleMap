package location.data.predicate;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface PredicateAndCounter<T> {
    boolean test(T t, int counter);
}
