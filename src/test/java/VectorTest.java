import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {
  @Test
  public void testCrossProduct() {
    Vector v1 = new Vector(6, -11, 11);
    Vector v2 = new Vector(7, -8, 9);

    assertEquals(v1.crossProduct(v2), new Vector(-11, 23, 29));

  }
}