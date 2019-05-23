package com.soft1841.design2;

public class FactoryTast {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.getCircleInstance();
        circle.draw();

        Shape rectangle = ShapeFactory.getRectangleInstance();
        rectangle.draw();

    }
}
