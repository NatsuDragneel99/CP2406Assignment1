import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    String userName;



    public MenuPanel() {
        setLayout(new FlowLayout());
        setVisible(true);
        JButton joinGame = new JButton("Join Game");
        joinGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAddUserFrame();
            }
        });
        add(joinGame);
    }

    private void displayAddUserFrame() {
        JFrame addUserFrame = new JFrame();
        addUserFrame.setResizable(false);
        addUserFrame.setVisible(true);
        addUserFrame.setSize(100,100);
        JPanel addUserPanel = new JPanel();
        addUserPanel.setLayout(new FlowLayout());
        JTextField addUserText = new JTextField(10);
        JButton addUserButton = new JButton("GO");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userName = addUserText.getText();
                addUserFrame.dispose();
            }
        });
        addUserFrame.add(addUserPanel);
        addUserPanel.add(addUserText);
        addUserPanel.add(addUserButton);
    }



    public static void main(String[] args) {
        MenuPanel test = new MenuPanel();
    }
}
