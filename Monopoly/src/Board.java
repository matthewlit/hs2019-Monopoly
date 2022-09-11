import javax.swing.*;
        import java.awt.*;

public class Board {
    public static void displayBoard(){
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(820, 840));
        frame.setTitle("Monopoly");
        ImageIcon board = new ImageIcon("C:\\Users\\matth\\OneDrive\\Documents\\High School Comp Sci\\board2.jpg");
        frame.add(new JLabel(board));
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
    }
}
