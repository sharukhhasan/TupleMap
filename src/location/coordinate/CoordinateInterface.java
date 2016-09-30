package location.coordinate;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
public interface CoordinateInterface {
    int x();
    int y();

    static CoordinateInterface create(final int argX, final int argY) {
        return new CoordinateInterface() {
            final int x = argX;
            final int y = argY;

            @Override
            public int x() {
                return x;
            }

            @Override
            public int y() {
                return y;
            }

            @Override
            public String toString() {
                return "(" + x + ", " + y + ")";
            }

            @Override
            public boolean equals(Object o) {
                if(o == this) {
                    return true;
                }

                if(o == null) {
                    return false;
                }

                if(!(o instanceof CoordinateInterface)) {
                    return false;
                }
                CoordinateInterface that = (CoordinateInterface) o;
                return x == that.x()  && y == that.y();
            }

            @Override
            public int hashCode() {
                return 31 * x + y;
            }

        };
    }

}