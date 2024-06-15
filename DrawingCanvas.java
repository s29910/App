import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas extends JPanel {
    private List<Shape> shapes;
    private ShapeFactory shapeFactory;

    public DrawingCanvas(ShapeFactory shapeFactory) {
        this.shapes = new ArrayList<Shape>();
        this.shapeFactory = shapeFactory;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Shape shape = shapeFactory.createShape(e.getX(),e.getY());
                // Create a new shape using the shapeFactory

                // Add the created shape to the shapes list
                shapes.add(shape);
                // Repaint the canvas to draw the new shape
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Draw all shapes in the shapes list
        // Hint: You can use For each loop

        super.paintComponent(g);
        for (Shape s: shapes){
            s.draw(g);
        }
    }
}