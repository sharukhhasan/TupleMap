package location.data.array;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface ArrayPredicate<T> {
    boolean test(T[] values);
}
