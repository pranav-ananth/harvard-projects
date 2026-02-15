import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceRollHistogram extends JFrame {
    private JTextField rollsInput;
    private JButton rollButton;
    private HistogramPanel histogramPanel;
    private int[] rollFrequencies = new int[13];
    private Random random = new Random();

    public DiceRollHistogram() {
        setTitle("Dice Roll Histogram");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Number of Rolls:"));
        rollsInput = new JTextField(10);
        inputPanel.add(rollsInput);
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
            int rolls = Integer.parseInt(rollsInput.getText());
            if (rolls <= 0) throw new NumberFormatException();

            // Reset frequencies
            for (int i = 2; i <= 12; i++) {
                rollFrequencies[i] = 0;
            }

            // Simulate dice rolls
            for (int i = 0; i < rolls; i++) {
                int die1 = random.nextInt(6) + 1;
                int die2 = random.nextInt(6) + 1;
                int sum = die1 + die2;
                rollFrequencies[sum]++;
            }

            histogramPanel.repaint();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid positive integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class HistogramPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int width = getWidth();
            int height = getHeight();
            int barWidth = width / 13;
            int maxCount = 1;
            for (int i = 2; i <= 12; i++) {
                maxCount = Math.max(maxCount, rollFrequencies[i]);
            }

            for (int i = 2; i <= 12; i++) {
                int barHeight = (int) ((double) rollFrequencies[i] / maxCount * (height - 40));
                int x = (i - 2) * barWidth + 20;
                int y = height - barHeight - 20;
                g.setColor(Color.BLUE);
                g.fillRect(x, y, barWidth - 5, barHeight);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, barWidth - 5, barHeight);
                g.drawString(i + "", x + barWidth / 4, height - 5);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DiceRollHistogram().setVisible(true);
        });
    }
}
