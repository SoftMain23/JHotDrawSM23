package org.jhotdraw.draw.tool;

import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.connector.Connector;
import org.jhotdraw.draw.event.FigureListener;
import org.jhotdraw.draw.figure.ConnectionFigure;
import org.jhotdraw.draw.figure.Figure;
import org.jhotdraw.draw.figure.TextFigure;
import org.jhotdraw.draw.figure.TextHolderFigure;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.text.FloatingTextField;
import org.jhotdraw.geom.Dimension2DDouble;
import org.jhotdraw.geom.Insets2D;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.event.KeyEvent;


public class TextEditingToolTest {

    @Test
    void testEndEditCalledOnEscape() {

        TextHolderFigure typingTarget = new TextFigure() {
        };
        TextEditingTool textEditingTool = new TextEditingTool(typingTarget);
        KeyEvent keyEvent = new KeyEvent(new Component(){}, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_ESCAPE, KeyEvent.CHAR_UNDEFINED);

        textEditingTool.keyReleased(keyEvent);

        assertTrue(textEditingTool.isEscapePressed());
        //assertFalse(textEditingTool.isEditing());

    }
}
