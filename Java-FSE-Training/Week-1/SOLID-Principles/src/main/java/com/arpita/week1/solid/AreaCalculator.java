package com.arpita.week1.solid;

import java.util.ArrayList;
import java.util.List;

public class AreaCalculator {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape s) {
        shapes.add(s);
    }

    public double totalArea() {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }
}
