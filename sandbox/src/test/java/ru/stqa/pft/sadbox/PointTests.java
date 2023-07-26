package ru.stqa.pft.sadbox;

import org.testng.annotations.Test;
import org.testng.Assert;

public class PointTests {
  @Test
  public void testArea() {
    Point point1 = new Point(0, 0);
    Point point2 = new Point(3, 4);

    double distance1 = Point.distance(point1, point2);

    // Проверяем, что расстояние равно 5.0
    Assert.assertEquals(distance1, 5.0);

  }

  @Test
  public void testDistanceMethod() {
    Point point1 = new Point(0, 0);
    Point point2 = new Point(3, 4);

    double distance2 = point1.distance(point2);

    // Проверяем, что расстояние равно 5.0
    Assert.assertEquals(distance2, 5.0);
  }
}
