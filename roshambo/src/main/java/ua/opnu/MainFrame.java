package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");
        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");
        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {
        int random = new Random().nextInt(3);
        switch (random) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            default:
                return new Scissors();
        }
    }

    private int checkWinner(GameShape player, GameShape computer) {
        if (player.getClass().equals(computer.getClass())) {
            return 0; // Нічия
        }
        
        if ((player instanceof Rock && computer instanceof Scissors) ||
            (player instanceof Paper && computer instanceof Rock) ||
            (player instanceof Scissors && computer instanceof Paper)) {
            return 1; // Переміг гравець
        }
        
        return -1; // Переміг комп'ютер
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameShape computerShape = generateShape();
        GameShape playerShape = null;

        switch (e.getActionCommand()) {
            case "rock":
                playerShape = new Rock();
                break;
            case "paper":
                playerShape = new Paper();
                break;
            case "scissors":
                playerShape = new Scissors();
                break;
        }

        int gameResult = checkWinner(playerShape, computerShape);

        String message = "Ваша фігура: " + playerShape + ". Фігура комп'ютера: " + computerShape + ". ";
        switch (gameResult) {
            case -1:
                message += "Комп'ютер переміг!";
                break;
            case 0:
                message += "Нічия!";
                break;
            case 1:
                message += "Ви перемогли!";
        }

        JOptionPane.showMessageDialog(null, message);
    }
}
