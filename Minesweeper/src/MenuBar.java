import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar{
    private MinesweeperGame minesweeperGame;
    private JMenu menu;

    public MenuBar(MinesweeperGame minesweeperGame){
        this.minesweeperGame = minesweeperGame;

        menu = new JMenu("Menu");
        JMenuItem newgame = new JMenuItem("New Game");
        JMenuItem easy = new JMenuItem("Easy");
        JMenuItem med = new JMenuItem("Medium");
        JMenuItem hard = new JMenuItem("Hard");
        JMenuItem exit = new JMenuItem("Exit");

        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Object[] options = { "Yes", "No" };
                int choice = JOptionPane.showOptionDialog(
                    null,
                    "Do you want to restart the game?",
                    "Restart",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
                );
                if(choice == JOptionPane.YES_OPTION){
                    minesweeperGame.resetGame();
                }
            }
        });

        easy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MinesweeperGame(5, 5, 5, 1);
                minesweeperGame.frame.dispose();
            }
        });

        med.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MinesweeperGame(10, 10, 40, 3);
                minesweeperGame.frame.dispose();
            }
        });

        hard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MinesweeperGame(20, 20, 100, 5);
                minesweeperGame.frame.dispose();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Launcher();
                minesweeperGame.frame.dispose();
            }
        });

        menu.add(newgame);
        menu.addSeparator();
        menu.add(easy);
        menu.add(med);
        menu.add(hard);
        menu.addSeparator();
        menu.add(exit);

        this.add(menu);
    }

    public MinesweeperGame getMinesweeperGame() {
        return minesweeperGame;
    }

    public void setMinesweeperGame(MinesweeperGame minesweeperGame) {
        this.minesweeperGame = minesweeperGame;
    }

    
}

