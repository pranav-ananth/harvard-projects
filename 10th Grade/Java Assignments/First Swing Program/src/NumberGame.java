import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGame extends JFrame implements ActionListener {
    private JButton[][] buttonArray = new JButton[3][3];
    private int[][] numberArray = new int[3][3];
    private int selections;
    private int oddCount;
    private boolean jackpotWon;

    public NumberGame() {
        selections = 0;
        oddCount = 0;
        jackpotWon = false;

        setName("Number Game");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,3));
        initGame();
        setVisible(true);
    }

    private void initGame() {
        Random random = new Random();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                numberArray[i][j] = random.nextInt(50) + 1;
                buttonArray[i][j] = new JButton(" ");
                buttonArray[i][j].addActionListener(this);
                add(buttonArray[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (selections < 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (e.getSource() == buttonArray[i][j] && buttonArray[i][j].getText().equals(" ")) {
                        buttonArray[i][j].setText(String.valueOf(numberArray[i][j]));
                        checkNumber(numberArray[i][j]);
                        selections++;
                        if (selections == 3) {
                            showResult();
                        }
                        return;
                    }
                }
            }
        }
    }

    public void checkNumber(int num) {
        if (num % 2 == 1) {
            oddCount++;
        }
        if (num == 50) {
            jackpotWon = true;
        }
    }

    public void showResult() {
        if(jackpotWon) {
            JOptionPane.showMessageDialog(null, "You won the jackpot!");
        }
        else {
            int prize = 0;
            switch (oddCount){
                case 1:
                    prize = 20;
                    break;
                case 2:
                    prize = 50;
                    break;
                case 3:
                    prize = 100;
                    break;
            }
            JOptionPane.showMessageDialog(null, "You won $" + prize + "!");
        }
    }

    public static void main(String args[]) {
        new NumberGame();
    }
}
