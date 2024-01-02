package org.jhotdraw.draw.tool;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.event.ToolEvent;
import org.jhotdraw.draw.figure.EllipseFigure;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.jhotdraw.draw.io.ImageOutputFormat;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Test;
import org.testng.reporters.jq.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

import static org.junit.Assert.assertEquals;

public class DefaultDragTrackerTest {

    @Test
    public void testSetDraggedFigure() {
        //mock
        DefaultDragTracker defaultDragTracker;
        Figure figure = new RectangleFigure();
        SelectionTool selectionTool = new SelectionTool();
        defaultDragTracker = (DefaultDragTracker) selectionTool.getDragTracker(figure);

        //assert
        assertEquals(defaultDragTracker.getDraggedFigure(), figure);
    }

    @Test
    public void testDragFigure() {
        //mock data
        DrawingView view1 = new DefaultDrawingView();
        view1.setDrawing(createDrawing());
        DrawingEditor editor = new DefaultDrawingEditor();
        editor.add(view1);
        SelectionTool selectionTool = new SelectionTool();
        selectionTool.activate(editor);
        DefaultDragTracker dragTracker = new DefaultDragTracker();
        selectionTool.setDragTracker(dragTracker);

        //Figure
        Figure figure = new RectangleFigure();
        view1.getDrawing().add(figure);

        //Positions
        double x = figure.getStartPoint().getX();
        double y = figure.getStartPoint().getY();

        //Mouse events
        MouseEvent mousePress = new MouseEvent(view1.getComponent(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        selectionTool.mousePressed(mousePress);
        MouseEvent mouseDrag = new MouseEvent(view1.getComponent(), MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, 10, 10, 0, false);
        selectionTool.mouseDragged(mouseDrag);

        //Assert
        if ((figure.getStartPoint().getX() != x || figure.getStartPoint().getY() != y) && (figure == dragTracker.getDraggedFigure())) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }
    }

    @Test
    public void testMoveFigureToPrecision() {
        //mock data

        DrawingView view1 = new DefaultDrawingView();
        view1.setDrawing(createDrawing());
        DrawingEditor editor = new DefaultDrawingEditor();
        editor.add(view1);
        SelectionTool selectionTool = new SelectionTool();
        selectionTool.activate(editor);
        DefaultDragTracker dragTracker = new DefaultDragTracker();
        selectionTool.setDragTracker(dragTracker);

        //Figure
        Figure figure = new EllipseFigure();
        view1.getDrawing().add(figure);

        //Mouse events
        MouseEvent mousePress = new MouseEvent(view1.getComponent(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        selectionTool.mousePressed(mousePress);
        MouseEvent mouseDrag = new MouseEvent(view1.getComponent(), MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, 10, 10, 0, false);
        selectionTool.mouseDragged(mouseDrag);

        //Assert if figure is moved to new position
        if (figure.getStartPoint().getX() == 10f && figure.getStartPoint().getY() == 10f) {
            assertEquals(true, true);
        } else {
            assertEquals(false, true);
        }
    }

    private static Drawing createDrawing() {
        // Create a default drawing with
        // input/output formats for basic clipboard support.
        DefaultDrawing drawing = new DefaultDrawing();
        drawing.addInputFormat(new SerializationInputOutputFormat());
        drawing.addOutputFormat(new SerializationInputOutputFormat());
        drawing.addOutputFormat(new ImageOutputFormat());
        return drawing;
    }

}
