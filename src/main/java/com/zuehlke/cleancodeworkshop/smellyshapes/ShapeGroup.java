package com.zuehlke.cleancodeworkshop.smellyshapes;

public class ShapeGroup extends AbstractShape {

    Shape[] shapes = new Shape[10];
    int size = 0;
    protected boolean readOnly = false;

    public ShapeGroup() {}

    public ShapeGroup(Shape[] shapes, boolean readOnly) {
        this.shapes = shapes;
        this.size = shapes.length;
        this.readOnly = readOnly;
    }

    public void add(Shape shape) {
        if (readOnly || contains(shape)) {
            return;
        }

        ensureThereIsSpaceForTheShape();

        shapes[size++] = shape;
    }

    private void ensureThereIsSpaceForTheShape() {
        if(size + 1 > shapes.length) {
            Shape[] newShapes = new Shape[shapes.length + 10];
            System.arraycopy(shapes, 0, newShapes, 0, size);
            shapes = newShapes;
        }
    }

    public boolean contains(Shape shape) {
        for (int i = 0; i < size; i++) {
            if (shapes[i].equals(shape)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(int x, int y) {
        for (Shape shape : shapes) {
            if (shape != null) {
                if (shape.contains(x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
}
