package com.soft1841;

public class FactoryTast {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getCircleInstance();
        circle.draw();

        Shape rectangle = ShapeFactory.getRectangleInstance();
        rectangle.draw();

    }
}
