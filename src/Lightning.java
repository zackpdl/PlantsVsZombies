import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Lightning extends JLabel {
    public Lightning(int x, int y) {
        setIcon(new ImageIcon(getClass().getResource("/PlantsVsZombies/src/images/Light.png")));
        setBounds(x, y, 50, 50); // Adjust the size and position as needed
    }
}
