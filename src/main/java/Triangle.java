import java.util.ArrayList;

public class Triangle {
  private final Point p, q, r;

  public Triangle(ArrayList<Point> polygon) {
    p = polygon.get(0);
    q = polygon.get(1);
    r = polygon.get(2);
  }

  public Triangle(Point p1, Point p2, Point p3) {
    p = p1;
    q = p2;
    r = p3;
  }

  public double surfaceArea() {
    var pq = new Vector(p, q);
    var pr = new Vector(p, r);
    return pq.crossProduct(pr).magnitude() / 2;
  }
}
