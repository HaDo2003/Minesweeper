
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyPanel extends JPanel {
    private JPanel cardPanel;

    public DifficultyPanel(JPanel cardPanel) {
        this.cardPanel = cardPanel;
        setLayout(new BorderLayout());

        Font font = new Font("Arial", Font.BOLD, 20);
        JLabel choice = new JLabel("Choose Level");
        choice.setFont(font);
        choice.setHorizontalAlignment(SwingConstants.CENTER);
        choice.setBackground(null);
        choice.setOpaque(false);

        JPanel panel_level = new JPanel();
        JPanel panel_option = new JPanel();
        panel_level.setLayout(new GridLayout(3, 1, 8, 8));
        panel_level.setBackground(null);
        panel_level.setOpaque(false);
        panel_option.setBackground(null);
        panel_option.setOpaque(false);

        JButton easyButton = new JButton("Easy");
        JButton medButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");
        JButton backlauncher = new JButton("Back to menu");

        choice.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MinesweeperGame(5, 5, 5, 1);
                hidePanel();
            }
        });

        medButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MinesweeperGame(10, 10, 20, 3);
                hidePanel();
            }
        });

        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MinesweeperGame(20, 20, 75, 5);
                hidePanel();
            }
        });


        backlauncher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher();
                hidePanel();
            }
        });

        
        panel_level.add(easyButton);
        panel_level.add(medButton);
        panel_level.add(hardButton);
        panel_option.add(backlauncher);
        
        this.add(choice, BorderLayout.NORTH);
        this.add(panel_level, BorderLayout.CENTER);
        this.add(panel_option, BorderLayout.SOUTH);
        this.setBackground(null);
        this.setOpaque(false);
        
    }

    private void hidePanel() {
        cardPanel.setVisible(false);
        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
