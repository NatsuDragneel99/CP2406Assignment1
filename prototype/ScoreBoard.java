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


    ScoreBoard(int score) {
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.BLACK);
        JLabel scoreLabel = new JLabel();
        scoreLabel.setText("Your score: " + score);
    }
}
