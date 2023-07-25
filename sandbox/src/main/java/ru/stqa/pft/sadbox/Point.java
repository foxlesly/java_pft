package ru.stqa.pft.sadbox;

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public static double distance(Point p1, Point p2) {
    double dx = p2.x - p1.x;
    double dy = p2.y - p1.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  // Новый метод distance, который вычисляет расстояние между текущей точкой и другой точкой
  public double distance(Point otherPoint) {
    double dx = otherPoint.x - this.x;
    double dy = otherPoint.y - this.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

}
