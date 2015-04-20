public class Point {
    private int x;
    private int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int get_x() {
        return this.x;
    }
    public int get_y() {
        return this.y;
    }
    private boolean equals(Point q) {
        if (this.x == q.get_x() && this.y == q.get_y()) {
            return true;
        }
        return false;
    }
}
