package location.data;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface ConsumerAndCounter<T> {
    void apply(T values, int counter);
}
