import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PaintApplet extends JPanel {
    private ArrayList<Shape> shapes;
    private Shape currentShape;
    private Color currentColor;

    public PaintApplet() {
        shapes = new ArrayList<>();
        currentColor = Color.black;

        // Set up mouse listeners
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                currentShape = new Shape();
                currentShape.setColor(currentColor);
                currentShape.addPoint(e.getX(), e.getY());
            }

            public void mouseReleased(MouseEvent e) {
                shapes.add(currentShape);
                currentShape = null;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentShape.addPoint(e.getX(), e.getY());
                repaint();
            }
        });

        // Set up color buttons
        JButton blackButton = new JButton("Black");
        blackButton.addActionListener(e -> setCurrentColor(Color.black));

        JButton redButton = new JButton("Red");
        redButton.addActionListener(e -> setCurrentColor(Color.red));

        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(e -> setCurrentColor(Color.blue));

        JPanel colorPanel = new JPanel();
        colorPanel.add(blackButton);
        colorPanel.add(redButton);
        colorPanel.add(blueButton);
        add(colorPanel);
    }

    private void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            g.setColor(shape.getColor());
            g.drawPolyline(shape.getXPoints(), shape.getYPoints(), shape.getNumPoints());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PaintApplet());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private static class Shape {
        private ArrayList<Integer> xPoints;
        private ArrayList<Integer> yPoints;
        private Color color;

        public Shape() {
            xPoints = new ArrayList<>();
            yPoints = new ArrayList<>();
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void addPoint(int x, int y) {
            xPoints.add(x);
            yPoints.add(y);
        }

        public int[] getXPoints() {
            return xPoints.stream().mapToInt(Integer::intValue).toArray();
        }

        public int[] getYPoints() {
            return yPoints.stream().mapToInt(Integer::intValue).toArray();
        }

        public int getNumPoints() {
            return xPoints.size();
        }
    }
}
