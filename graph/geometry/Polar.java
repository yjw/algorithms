import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;


public class Polar {
    public static void main (String[] args) {
        ArrayList<Point> array = new ArrayList<Point>();
        array.add(new Point(1000, 0));
        array.add(new Point(2, -2));
        array.add(new Point(2, 0));
        array.add(new Point(2, 2));
        array.add(new Point(-2, 2));
        array.add(new Point(-2, -2));
        //array.add(new Point(2, -2));
        Point origin = new Point(0, 0);
        Collections.sort(array, new PolarComparator(origin));
        for (Point x : array) {
            System.out.println(x.get_x() + ", " + x.get_y());
        }
    }
}



class PolarComparator implements Comparator<Point> {
    Point origin;
    PolarComparator(Point p) {
        origin = p;
    }
    public int compare (Point p1, Point p2) {
        Point p = new Point(p1.get_x() - origin.get_x(), p1.get_y() - origin.get_y());
        Point q = new Point(p2.get_x() - origin.get_x(), p2.get_y() - origin.get_y());
        if (p.)
        if (cross(p, q) == 0) {
            return 0;
        } 
        if (cross(p, q) > 0) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
    private static int cross (Point p1, Point p2) {
        return p1.get_x() * p2.get_y() - p1.get_y() * p2.get_x();
    }
    
}
