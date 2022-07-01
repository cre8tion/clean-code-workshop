package com.zuehlke.cleancodeworkshop.smellyshapes;

import java.util.HashSet;
import java.util.Set;

public class ShapeGroup implements Shape {

    Set<Shape> shapesSet = new HashSet<>();
    int size = 0;
    protected boolean readOnly = false;

    public ShapeGroup() {}

    public ShapeGroup(Shape[] shapes, boolean readOnly) {
        this.shapesSet = Set.of(shapes);
        this.size = shapes.length;
        this.readOnly = readOnly;
    }

    public ShapeGroup(Set<Shape> shapes, boolean readOnly) {
        this.shapesSet = shapes;
        this.size = shapes.size();
        this.readOnly = readOnly;
    }

    public void add(Shape shape) {
        if (readOnly || contains(shape)) {
            return;
        }
        this.shapesSet.add(shape);
        size++;
    }

    public boolean contains(Shape shape) {
        return shapesSet.contains(shape);
    }

    public boolean contains(int x, int y) {
        return shapesSet.stream().anyMatch(s -> s.contains(x, y));
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public String toXml() {
        StringBuilder builder = new StringBuilder();
        builder.append("<shapegroup>\n");
        this.shapesSet.forEach(shape -> builder.append(shape.toXml()));
        builder.append("</shapegroup>\n");
        return builder.toString();
    }
}
