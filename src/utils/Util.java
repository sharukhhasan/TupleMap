package utils;

import location.Position;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by Sharukh Hasan on 9/30/16.
 */
public class Util {

    private Util() {}

    private static Util thisInstance = new Util();

    protected static Util getInstance() {
        return thisInstance;
    }

    //Calculates the radian angle from point a to point b
    private static double angleOf(Point2D a, Point2D b) {
        double x = b.getX() - a.getX();
        double y = b.getY() - a.getY();
        return Math.atan2(y, x);
    }

    //Adds two radian angles and returns a value between -Pi and Pi
    private static double addAngles(double a, double b) {
        return Util.normalize(a + b);
    }

    //Adjusts radian angles to be values between -Pi and Pi.
    public static double normalize(double raw) {
        while(raw < -Math.PI) {
            raw += 2 * Math.PI;
        }

        while(raw > Math.PI) {
            raw -= 2 * Math.PI;
        }
        return raw;
    }

    public static Point2D intersection(Line2D a, Line2D b) {
        double x1 = a.getX1(), y1 = a.getY1(), x2 = a.getX2(), y2 = a.getY2(),
                x3 = b.getX1(), y3 = b.getY1(), x4 = b.getX2(), y4 = b.getY2();
        double d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

        if(d == 0) {
            return null;
        }

        double xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
        double yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;

        return new Point2D.Double(xi, yi);
    }

    public static double sum(List<Double> scores) {
        double f = 0.0;
        for(Double score : scores) {
            f += score;
        }
        return f;
    }

    public static List<Double> normalizeMinusOne(List<Double> values) {
        List<Double> retVal = new ArrayList<Double>();
        for(Double x : normalize(values)) {
            retVal.add(1.0 - x);
        }
        return retVal;
    }

    public static List<Double> normalize(List<Double> values) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(Double x : values) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }

        List<Double> retVal = new ArrayList<Double>();
        for(Double x : values) {
            if(min == max) {
                retVal.add(Math.random());
            } else {
                retVal.add((x - min)/(max - min));
            }
        }
        return retVal;
    }

    public static double euclidianDistance(List<Double> alpha, List<Double> beta) {
        if(alpha.size() != beta.size()) {
            throw new IllegalStateException("Size of the actual measurement list and the hypothesis measurment list must be equal.");
        }

        double euclidianDist = 0.0;
        for(int i = 0; i < alpha.size(); i++) {
            euclidianDist += Math.pow(alpha.get(i) - beta.get(i), 2);
        }
        return Math.sqrt(euclidianDist);
    }

    private static Point2D convertToCartesian(Position pose, Double angle, Double range) {
        Double x = pose.getX();
        Double y = pose.getY();

        Double theta = Util.normalize(pose.getTheta() + angle);
        Double dx = Math.cos(theta) * range;
        Double dy = Math.sin(theta) * range;

        return new Point2D.Double(x + dx, y+ dy);
    }

    public static Collection<Point2D> convertToCartesian(Position robotPose, Map<Double, Double> rangeReadings) {
        Collection<Point2D> retVal = new HashSet<Point2D>();
        for(Double angleKey : rangeReadings.keySet()) {
            retVal.add(convertToCartesian(robotPose, angleKey, rangeReadings.get(angleKey)));
        }
        return retVal;
    }
}
