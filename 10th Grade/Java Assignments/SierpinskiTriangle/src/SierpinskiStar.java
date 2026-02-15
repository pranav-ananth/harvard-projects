
import javax.swing.*;
import java.awt.*;

public class SierpinskiStar extends JPanel {
    private int depth;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        drawStars(g, width/2, height/2, 60, depth);
    }

    private void drawStar(Graphics g, int x, int y, int radius) {
        double angle = Math.PI / 2; // Start at the top
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        for (int i = 0; i < 10; i++) {
            double r = (i % 2 == 0) ? radius : radius / 2.5;
            xPoints[i] = x + (int) (r * Math.cos(angle));
            yPoints[i] = y - (int) (r * Math.sin(angle));
            angle += Math.PI / 5;
        }

        g.fillPolygon(xPoints, yPoints, 10);
    }

    public void drawStars(Graphics g, int x, int y, int radius, int depth) {
        if (depth == 0) {
            drawStar(g, x, y, radius);
        } else {
            drawStar(g, x, y, radius);

            int newRadius = radius / 2;
            int offset = (int)(radius * 1.5);

            drawStars(g, x - offset, y, newRadius, depth - 1); // Left
            drawStars(g, x + offset, y, newRadius, depth - 1); // Right
            drawStars(g, x, y - offset, newRadius, depth - 1); // Up
            drawStars(g, x, y + offset, newRadius, depth - 1); // Down
        }
    }

    public void setDepth(int depth) {
        this.depth = depth;
        repaint();
    }

    public SierpinskiStar() {
        depth = 4; // default starting depth
        createPanel();
    }

    public void createPanel() {
        JFrame frame = new JFrame("Sierpinski Stars");


        JPanel depthPanel = new JPanel();
        JTextField depthInput = new JTextField(4);
        JButton depthButton = new JButton("Set Depth");

        depthButton.addActionListener(e -> setDepth(Integer.parseInt(depthInput.getText())));

        JLabel depthLabel = new JLabel("Depth: ");
        depthPanel.add(depthLabel);
        depthPanel.add(depthInput);
        depthPanel.add(depthButton);

        frame.setLayout(new BorderLayout());
        frame.add(depthPanel, BorderLayout.NORTH);
        frame.add(this, BorderLayout.CENTER);

        frame.setSize(800, 820);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new SierpinskiStar();
    }
}
