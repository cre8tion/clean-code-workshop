package com.zuehlke.cleancodeworkshop.smellyshapes;

public class Circle extends SimpleShape {

    private int x;
    private int y;
    private int radius;
    private Color color = new Color("Green");

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean contains(int x, int y) {
        return distanceTo(x, y) <= square(radius);
    }

    private int distanceTo(int x, int y) {
        int distanceX = x - this.x;
        int distanceY = y - this.y;
        return square(distanceX) + square(distanceY);
    }

    private int square(int x) {
        return x * x;
    }

    public int countContainingPoints(int[] xCords, int[] yCords) {
        int numberOfContainingPoints = 0;
        for (int i = 0; i < xCords.length; ++i) {
            if(contains(xCords[i], yCords[i])){
                numberOfContainingPoints++;
            }
        }
        return numberOfContainingPoints;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public String toString() {
        return "Circle: (" + this.x + "," + this.y + ") radius= " + radius
                + " RGB=" + this.color.getRed() + ","
                + this.color.getGreen() + ","
                + this.color.getBlue();
    }
}
