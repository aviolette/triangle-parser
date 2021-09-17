import java.util.Objects;

public class Vector {
  private final double x;
  private final double y;
  private final double z;
  public Vector(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  public Vector(Point p1, Point p2) {
    x = p2.x() - p1.x();
    y = p2.y() - p1.y();
    z = p2.z() - p1.z();
  }

  public Vector crossProduct(Vector v2) {
    return new Vector((y * v2.z) - (z * v2.y), -((x * v2.z) - (z * v2.x)), (x * v2.y) - (y * v2.x));
  }

  public double magnitude() {
    return Math.sqrt(x*x + y*y + z*z);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vector vector = (Vector) o;
    return Double.compare(vector.x, x) == 0 && Double.compare(vector.y, y) == 0 && Double.compare(vector.z, z) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, z);
  }

  @Override
  public String toString() {
    return "Vector{" +
        "x=" + x +
        ", y=" + y +
        ", z=" + z +
        '}';
  }
}
