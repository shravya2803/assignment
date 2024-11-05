import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class practice extends JFrame {
    public static void main(String[] args) {
        // Create a new JFrame
        practice frame = new practice();
        
    }
    private practice(){
        JFrame frame = new JFrame("My GUI");
        setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // Create a new JButton
        JButton button = new JButton("Open New Panel");

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new JPanel
                JPanel newPanel = new JPanel();
                newPanel.add(new JLabel("This is a new panel!"));

                // Create a new JFrame for the new panel
                JFrame newFrame = new JFrame("New Panel");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.add(newPanel);
                newFrame.pack();
                newFrame.setVisible(true);
            }
        });

        // Add the button to the frame
        frame.getContentPane().add(button, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}