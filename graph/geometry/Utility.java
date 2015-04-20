public class Utility {
/*
 * If p1 * p2 is positive, then p1 is clockwise 
 * from p2 with respect to the origin (0, 0);
 * if this cross product is negative, then p1 
 * is counterclockwise from p2 .
*/
    public static int cross (Point p1, Point p2) {
        return p1.get_x() * p2.get_y() - p1.get_y() * p2.get_x();
    }
    
    // == 0 at least two of them are colinear
    // < 0 right turn
    // > 0 left turn
    public static int direction (Point p0, Point p1, Point p2) {
        if (p0.equals(p1) || p0.equals(p2) || p1.equals(p2)) {
            return 0;
        }
        Point p = new Point(p1.get_x() - p0.get_x(), p1.get_y() - p0.get_y());
        Point q = new Point(p2.get_x() - p0.get_x(), p2.get_y() - p0.get_y());
        int direction = cross(p, q);
        if (direction == 0) {
            return 0;
        }
        if (direction < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }
    
    // check if point p0 is on line segment p1p2
    public static boolean on_segment (Point p1, Point p2, Point p0) {
        Point p = new Point(p0.get_x() - p1.get_x(), p0.get_y() - p1.get_y());
        Point q = new Point(p2.get_x() - p1.get_x(), p2.get_y() - p1.get_y());
        if (cross(p, q) != 0) {
            return false;
        }
        if (p0.get_x() <= Math.max(p1.get_x(), p2.get_x()) && p0.get_x() >= Math.min(p1.get_x(), p2.get_x()) 
            && p0.get_y() <= Math.max(p1.get_y(), p2.get_y())&& p0.get_y() >= Math.min(p1.get_y(), p2.get_y())) {
            return true;
        }
        return false;
    }
    
    /*
     * Check if line segments p1p2 and p3p4 intersect
     */
    public static boolean intersect (Point p1, Point p2, Point p3, Point p4) {
        int d1 = direction(p1, p2, p3);
        int d2 = direction(p1, p2, p4);
        int d3 = direction(p3, p4, p1);
        int d4 = direction(p3, p4, p2);
        if ((d1 < 0 && d2 > 0 || d1 > 0 && d2 < 0) && (d3 < 0 && d4 > 0 || d3 > 0 && d4 < 0)) {
            return true;
        }
        if (d1 == 0 && on_segment(p1, p2, p3)) {
            return true;
        }
        if (d2 == 0 && on_segment(p1, p2, p4)) {
            return true;
        }
        if (d3 == 0 && on_segment(p3, p4, p1)) {
            return true;
        }
        if (d4 == 0 && on_segment(p3, p4, p2)) {
            return true;
        }
        return false;
    }
    
    
    /*
     * Check if a Point p inside a triangle (p1, p2, p3)
     */
    
    private static int sign (Point p, Point q, Point r) {
        return (p.get_x() - r.get_x()) * (q.get_y() - r.get_y())
            - (q.get_x() - r.get_x()) * (p.get_y() - r.get_y());
    }
    
    public static boolean triangle (Point p, Point p1, Point p2, Point p3) {
        boolean b1, b2, b3;
        b1 = sign(p, p1, p2) < 0;
        b2 = sign(p, p2, p3) < 0;
        b3 = sign(p, p3, p1) < 0;
        return ((b1 == b2) && (b2 == b3));
    }
    
    public static void main (String[] args) {
        Point p2 = new Point(2, 0);
        Point p1 = new Point(2, 1);
        Point p0 = new Point(1, 2);
        System.out.println(direction(p0, p1, p2));
    }
}
