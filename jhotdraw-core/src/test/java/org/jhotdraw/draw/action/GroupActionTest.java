package org.jhotdraw.draw.action;

import static org.junit.Assert.assertArrayEquals;

import java.util.Collection;

import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.figure.CompositeFigure;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.RectangleFigure;

public class GroupActionTest {
    DrawingView dw = new DefaultDrawingView();
    DrawingEditor de = new DefaultDrawingEditor();

    //class to be tested
    GroupAction ga = new GroupAction(de);

    //Figures
        Figure figure1 = new RectangleFigure();
        Figure figure2 = new RectangleFigure();

    /*public void testGroupFigure() {
        CompositeFigure group;
        Collection<Figure> figures;

        //add figures
        group.add(figure1);
        figures.add(figure2);

        //run method
        ga.groupFigures(dw, group,figures);

        //expected output
        Collection<Figure> expectedSet;
        expectedSet.add(figure2);
    
        //assert
        assertArrayEquals(expectedSet,dw.getSelectedFigures());
        
    }*/
}
