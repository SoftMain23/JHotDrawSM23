package org.jhotdraw.gui;

import org.jhotdraw.gui.plaf.palette.PaletteToolBarUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaletteToolBarUITest {

    private PaletteToolBarUI paletteToolBarUI;
    private JToolBar toolBar;
    private PaletteToolBarUI.DragWindow dragWindow;
    private Container dockingSource;

    @BeforeEach
    void setUp() {
        toolBar = mock(JToolBar.class);
        dragWindow = mock(PaletteToolBarUI.DragWindow.class);
        dockingSource = mock(Container.class);
        paletteToolBarUI = new PaletteToolBarUI();
        paletteToolBarUI.toolBar = toolBar;
        paletteToolBarUI.dragWindow = dragWindow;
        paletteToolBarUI.dockingSource = dockingSource;

        when(toolBar.isFloatable()).thenReturn(true);
        when(dragWindow.getOffset()).thenReturn(new Point(0, 0));
        when(dockingSource.getLocationOnScreen()).thenReturn(new Point(0, 0));
    }

    @Test
    void testSetFloatingTrue() {
        Point p = new Point(100, 100);
        paletteToolBarUI.setFloating(true, p);
        assertTrue(paletteToolBarUI.isFloating());

    }

    @Test
    void testSetFloatingFalse() {
        Point p = new Point(100, 100);
        paletteToolBarUI.setFloating(false, p);
        assertFalse(paletteToolBarUI.isFloating());

    }

    @Test
    void testSetFloatingLocation() {
        int x = 200, y = 300;
        paletteToolBarUI.setFloatingLocation(x, y);
        assertEquals(x, paletteToolBarUI.floatingX);
        assertEquals(y, paletteToolBarUI.floatingY);
    }

    @Test
    void testFloatAt() {
        Point position = new Point(50, 50);
        Point origin = new Point(20, 30);

        paletteToolBarUI.floatAt(position, origin);
        assertEquals(origin.x + position.x, paletteToolBarUI.floatingX);
        assertEquals(origin.y + position.y, paletteToolBarUI.floatingY);

    }

    /*@Test
    public void testDragTo() {
        // Set up the conditions for the test
        when(toolBar.isFloatable()).thenReturn(true);
        when(dragWindow.getOffset()).thenReturn(new Point(0, 0));  // Adjust as needed
        when(toolBar.getSize()).thenReturn(new Dimension(100, 100));  // Adjust as needed
        when(dockingSource.getLocationOnScreen()).thenReturn(new Point(0, 0));  // Adjust as needed

        // Call the method under test
        Point position = new Point(10, 10);  // Adjust as needed
        Point origin = new Point(5, 5);  // Adjust as needed
        paletteToolBarUI.dragTo(position, origin);

        // Verify the results
        // You'll need to verify the expected outcomes depending on what dragTo is supposed to do
        assertEquals(dragWindow, times(1)).setLocation(10, 10);
        // Add more verification/assertion statements as needed based on the expected behavior
    }*/

}