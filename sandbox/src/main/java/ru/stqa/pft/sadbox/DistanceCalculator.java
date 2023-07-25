package ru.stqa.pft.sadbox;

public class DistanceCalculator {
  public static void main(String[] args) {
    Point point1 = new Point(0, 0);
    Point point2 = new Point(3, 4);

    double distance = Point.distance(point1, point2);
    System.out.println("Расстояние между точками: " + distance);

    // Используем новый метод distance, добавленный в класс Point
    double distance2 = point1.distance(point2);
    System.out.println("Расстояние между точками (через метод в классе Point): " + distance2);
  }


}
