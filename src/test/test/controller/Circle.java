package test.controller;

public class Circle {
    private final Double PI = 3.14;

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.getArea(3);
        circle.getLength(3);
    }

    public void getLength(float r) {
        System.out.println("周长：" + (2 * PI * r));
    }

    public void getArea(float r) {
        System.out.println("面积：" + (PI * r * r));
    }
}
