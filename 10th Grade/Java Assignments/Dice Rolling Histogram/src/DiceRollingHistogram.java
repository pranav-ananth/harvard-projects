import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceRollingHistogram extends JFrame {
    private JTextField rollCountInput;
    private JButton rollButton;
    private HistogramPanel histogramPanel;
    private int[] rollFrequencies = new int[13];
    private Random random = new Random();

    public DiceRollingHistogram() {
        setTitle("Dice Roll Histogram");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Number of Rolls:"));
        rollCountInput = new JTextField(10);
        inputPanel.add(rollCountInput);
        add(inputPanel, BorderLayout.NORTH);

        // Histogram panel
        histogramPanel = new HistogramPanel();
        add(histogramPanel, BorderLayout.CENTER);

        // Bottom panel for button
        JPanel buttonPanel = new JPanel();
        rollButton = new JButton("Roll Dice");
        buttonPanel.add(rollButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button action listener
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        try {
            int rollCount = Integer.parseInt(rollCountInput.getText());
            if (rollCount <= 0) throw new NumberFormatException();

            // Reset frequencies
            for (int i = 2; i <= 12; i++) {
                rollFrequencies[i] = 0;
            }

            // Simulate rolls
            for (int i = 0; i < rollCount; i++) {
                int die1 = random.nextInt(6) + 1;
                int die2 = random.nextInt(6) + 1;
                rollFrequencies[die1 + die2]++;
            }

            histogramPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid positive integer.");
        }
    }

    private class HistogramPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();

            int barWidth = width / 13;
            int maxRolled = 1; // the maximum number of times a specific roll was rolled

            for(int i = 2; i <= 12; i++) {
                maxRolled = Math.max(maxRolled, rollFrequencies[i]);
            }

            // Draw histogram
            for(int i = 2; i <= 12; i++) {
                int barHeight = (int) ( (((double)(rollFrequencies[i])) / maxRolled) * (height - 40) );
                int x = ((i - 2) * barWidth) + 20;
                int y = height - barHeight - 20;
                g.setColor(Color.BLUE);
                g.fillRect(x, y, barWidth - 5, barHeight);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, barWidth - 5, barHeight);
                g.drawString(i + "", x + barWidth / 4, height - 5);
            }
        }
    }

    public static void main(String args[]) {
        new DiceRollingHistogram().setVisible(true);
    }
}