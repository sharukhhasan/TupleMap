package location.coordinate;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
@FunctionalInterface
public interface CoordinateFactory<T> {
    T create(int x, int y);
}
