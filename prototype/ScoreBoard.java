import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
/**
 * Created by JC428209 on 2/11/17.
 */
public class ScoreBoard extends JPanel {


    ScoreBoard(GameFrame gameFrame, int score) {
        //setLayout(new FlowLayout());
        setLayout(new GridBagLayout());
        setVisible(true);
        setBackground(Color.BLACK);
        JLabel scoreLabel = new JLabel();
        scoreLabel.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        scoreLabel.setText("Your score: " + score);
        scoreLabel.setForeground(Color.cyan);
        add(scoreLabel);
    }
}
