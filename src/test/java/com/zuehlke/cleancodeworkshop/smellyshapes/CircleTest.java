package com.zuehlke.cleancodeworkshop.smellyshapes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircleTest {

    private Circle circle;

    @BeforeEach
    public void setUp() {
        circle = new Circle(0, 0, 1);
        circle.setColor(new Color("Red"));
    }

    @Test
    public void contains() {
        assertTrue(circle.contains(0, 0));
        assertTrue(circle.contains(0, 1));
        assertTrue(circle.contains(1, 0));

        assertFalse(circle.contains(1, 1));
        assertFalse(circle.contains(-1, -1));
        assertFalse(circle.contains(1, -1));
        assertFalse(circle.contains(-1, 1));

    }

    @Test
    public void countContainingPoints() {
        int result = circle.countContainingPoints(new int[]{0, 10}, new int[]{0, 10});

        assertEquals(1, result);
    }

    @Test
    public void toXml() {
        String xml = circle.toXml();

        assertEquals("<circle x=\"0\" y=\"0\" radius=\"1\" />\n", xml);
    }

    @Test
    public void toString_() {
        assertEquals("Circle: (0,0) radius= 1 RGB=255,0,0", circle.toString());
    }
}
