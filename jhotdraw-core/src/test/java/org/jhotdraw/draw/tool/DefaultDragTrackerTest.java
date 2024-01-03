package org.jhotdraw.draw.tool;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;
import org.jhotdraw.draw.io.ImageOutputFormat;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import org.junit.Test;
import java.awt.event.MouseEvent;

import static org.junit.Assert.assertEquals;

public class DefaultDragTrackerTest {

    DrawingView view = new DefaultDrawingView();
    DrawingEditor editor = new DefaultDrawingEditor();
    SelectionTool selectionTool = new SelectionTool();
    DragTracker defaultDragTracker = new DefaultDragTracker();


    @Test
    public void testSetDraggedFigure() {
        //mock
        Figure figure = new RectangleFigure();
        defaultDragTracker = selectionTool.getDragTracker(figure);

        //assert
        assertEquals(defaultDragTracker.getDraggedFigure(), figure);
    }

    @Test
    public void testDragFigure() {
        //mock data
        view.setDrawing(createDrawing());
        editor.add(view);
        selectionTool.activate(editor);
        selectionTool.setDragTracker(defaultDragTracker);

        //Figure
        Figure figure = new RectangleFigure();
        view.getDrawing().add(figure);

        //Positions
        int newPosX = 10;
        int newPosY = 10;

        //Mouse events
        MouseEvent mousePress = new MouseEvent(view.getComponent(), MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 0, 0, 1, false);
        selectionTool.mousePressed(mousePress);
        MouseEvent mouseDrag = new MouseEvent(view.getComponent(), MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, newPosX, newPosY, 0, false);
        selectionTool.mouseDragged(mouseDrag);

        //Assert if figure is moved to new position
        double expectedX = 10.0;
        double expectedY = 10.0;
        double delta = 0.0001;

        assertEquals(expectedX, figure.getStartPoint().getX(), delta);
        assertEquals(expectedY, figure.getStartPoint().getY(), delta);
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
