package location.coordinate;

/**
 * Created by Sharukh Hasan on 9/30/16
 *
 * Stores 2D coordinates
 */
public class Coordinate implements CoordinateInterface {

    public final int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    public Coordinate decX() {
        return addX(-1);
    }

    public Coordinate decY() {
        return addY(-1);
    }

    public Coordinate incX() {
        return addX(1);
    }

    public Coordinate incY() {
        return addY(1);
    }

    public Coordinate addX(int offset) {
        return new Coordinate(x + offset, y);
    }

    public Coordinate addY(int offset) {
        return new Coordinate(x, y + offset);
    }

    public Coordinate add(Coordinate coord) {
        return new Coordinate(x + coord.x, y + coord.y);
    }

    public Coordinate setX(int xNew) {
        return new Coordinate(xNew, y);
    }

    public Coordinate setY(int yNew) {
        return new Coordinate(x, yNew);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof CoordinateInterface)) return false;
        CoordinateInterface that = (CoordinateInterface) o;
        return x == that.x()  && y == that.y();
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}