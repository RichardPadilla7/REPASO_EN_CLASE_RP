import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Mi aplicación");
        frame.setContentPane(new carros().from1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2600, 200);
        frame.pack();
        frame.setVisible(true);
    }
}
