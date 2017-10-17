import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
public class DrawPanel extends JPanel {
    private GamePanel.Drawable drawable;


    public DrawPanel(GamePanel.Drawable drawable) {
        this.drawable = drawable;
    }

    public void setDrawable(GamePanel.Drawable drawable) {
        this.drawable = drawable;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawable != null) {
            drawable.draw(g);
        }
    }
}
