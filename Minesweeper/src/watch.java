/*  Name: Hà Đỗ Tây Đô
    ID: ITITIU21177
    Purpose: The watch class provides a mechanism to track the time 
    taken by a player to complete a game of Minesweeper. It displays 
    the elapsed time in a format of hours, minutes, and seconds, and 
    it controls the start, stop, and reset functionality of the timer. 
    This timekeeping feature enhances the game by allowing players to 
    gauge their performance and compare their times with others on leaderboards.
*/

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class watch extends JLabel{
    private MinesweeperGame minesweeperGame;
    int elapsedTime = 0;
    int second = 0;
    int minute = 0;
    int hour = 0;
    boolean started = false;
    String second_string = String.format("%02d", second);
    String minute_string = String.format("%02d", minute);
    String hour_string = String.format("%02d", hour);
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e){
            elapsedTime += 1000;
            hour = (elapsedTime/3600000);
            minute = (elapsedTime/60000) % 60;
            second = (elapsedTime/1000) % 60;
            second_string = String.format("%02d", second);
            minute_string = String.format("%02d", minute);
            hour_string = String.format("%02d", hour);
            setText(hour_string + ":" + minute_string + ":" + second_string);
        }
    });


    public watch(MinesweeperGame minesweeperGame){
        this.minesweeperGame = minesweeperGame;

        this.setText(hour_string+":"+minute_string+":"+second_string);
        this.setBounds(50,50,10,10);
        this.setFont(new Font("Verdana",Font.PLAIN,25));
        this.setBorder(BorderFactory.createBevelBorder(1));
        this.setOpaque(true);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setFocusable(false);
    }

    void start(){
        timer.start();
    }

    void stop(){
        timer.stop();
    }

    void reset(){
        timer.stop();
        elapsedTime=0;
        second = 0;
        minute = 0;
        hour = 0;
        second_string = String.format("%02d", second);
        minute_string = String.format("%02d", minute);
        hour_string = String.format("%02d", hour);       
        this.setText(hour_string+":"+minute_string+":"+second_string);
    }

    String getTime(){
        timer.stop();
        return hour_string + ":" + minute_string + ":" + second_string;
    }

    public MinesweeperGame getMinesweeperGame() {
        return minesweeperGame;
    }

    public void setMinesweeperGame(MinesweeperGame minesweeperGame) {
        this.minesweeperGame = minesweeperGame;
    }   
}