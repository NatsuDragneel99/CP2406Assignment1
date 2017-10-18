import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {




    public MenuPanel() {
        setLayout(new FlowLayout());
        setVisible(true);
        JButton joinGame = new JButton();
        joinGame.setText("Join Game");
        add(joinGame);
    }

    public static void main(String[] args) {
        MenuPanel test = new MenuPanel();
    }
}
