/*  Name: Hà Đỗ Tây Đô
    ID: ITITIU21177
    Purpose: The hint class extends JButton, representing a button that players can click 
    to receive hints in the game. The purpose of this class is to assist players by revealing 
    a hint when they are stuck or unsure of their next move.
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class hint extends JButton{
    MinesweeperGame mg;

    public hint(MinesweeperGame mg){
        this.mg = mg;

        URL urlHint = hint.class.getResource("/img/hint.png");
        Image img = Toolkit.getDefaultToolkit().createImage(urlHint);
        Image scaledImg = img.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImg);
        this.setIcon(icon);
        Dimension size = new Dimension(32, 32);
        this.setPreferredSize(size);
        this.setMinimumSize(size);
        this.setMaximumSize(size);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setOpaque(false);
        
        this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(mg.hintcount > 0){
                    JOptionPane.showMessageDialog(null, "Hint Left:" + mg.hintcount);
                    giveHint();
                    mg.hintcount--;
                }else{
                    JOptionPane.showMessageDialog(null, "Out of hint");
                }
            }
        });
    }
    public void giveHint() {
        for (MineTile tile : mg.mineList) {
            if (tile.isEnabled() && !tile.getText().equals("🚩")) {
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int nr = tile.r + dr;
                        int nc = tile.c + dc;
                        if (nr >= 0 && nr < mg.numRows && nc >= 0 && nc < mg.numCols) {
                            MineTile adjacentTile = mg.board[nr][nc];
                            if (!adjacentTile.isEnabled()) {
                                tile.setBackground(Color.RED);
                                Timer timer = new Timer(1000, new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        tile.setBackground(null);
                                    }
                                });
                                timer.setRepeats(false);
                                timer.start();
                                return;
                            }
                        }
                    }
                }
            }
        }
    } 
}