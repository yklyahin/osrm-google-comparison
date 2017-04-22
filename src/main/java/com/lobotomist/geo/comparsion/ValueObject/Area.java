package com.lobotomist.geo.comparsion.ValueObject;

public class Area {
    private Location leftTop;
    private Location rightBottom;

    public Area(Location leftTop, Location rightBottom) {
        this.leftTop = leftTop;
        this.rightBottom = rightBottom;
    }

    public Location getLeftTop() {
        return leftTop;
    }

    public Location getRightBottom() {
        return rightBottom;
    }
}
