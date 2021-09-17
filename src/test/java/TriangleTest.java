import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {
  @Test
  public void surfaceArea() {
    Triangle t = new Triangle(new Point(-5, 5, -5), new Point(1, -6, 6), new Point(2, -3, 4));
    assertEquals(t.surfaceArea(), 19.306, 0.001);
  }
}