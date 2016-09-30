package location;

import java.awt.geom.Point2D;

import utils.Util;

/**
 * Created by Sharukh Hasan on 9/29/16
 *
 */
public class Position extends Point2D {

    public Position(double x, double y, double theta) {
        setLocation(x, y);
        this.theta = Util.normalize(theta);
    }

    public Position(Position aPosition) {
        this(aPosition.x, aPosition.y, aPosition.theta);
    }

    public boolean equals(Position pose) {
        boolean equal = true;
        if(x != pose.x) {
            equal = false;
        }

        if(y != pose.y) {
            equal = false;
        }

        if(theta != pose.theta) {
            equal = false;
        }
        return equal;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getTheta() {
        return theta;
    }

    protected Position add(Position other) {
        return add(other.x, other.y, other.theta);
    }

    public Position add(double dx, double dy, double dTheta) {
        double x = this.x + dx, y = this.y + dy, t = Util.normalize(theta + dTheta);
        return new Position(x, y, t);
    }

    private double x, y, theta;

    public Point2D getPoint2D() {
        return this;
    }
}