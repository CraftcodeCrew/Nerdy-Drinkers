package munich.nerdy.drinkers.ui;

import munich.nerdy.drinkers.utility.BackgroundPanel;
import munich.nerdy.drinkers.utility.Utility;

import javax.swing.*;
import java.awt.*;

/**
 * Created by leong on 23.06.2016.
 */
public class GameGUI {

    private JFrame frame;
    private JPanel top = new JPanel();
    private JPanel mid = new JPanel();
    private JPanel bottom = new JPanel();

    private JLabel sloganLabel = new JLabel("Nerdy-Drinkers");
    private JButton newPlayerButton = new JButton();
    private JButton startButton = new JButton();
    private JLabel playersLabel = new JLabel("Spieler:");


    public GameGUI() {

        ImageIcon backgroundIcon = new ImageIcon("src/resources/beer-gif.gif");
        Image backgroundImage = backgroundIcon.getImage();

        BackgroundPanel mid =
                new BackgroundPanel(backgroundImage , BackgroundPanel.ACTUAL, 1.0f, 0.5f);

        frame = new JFrame("Nerdy-Drinkers");
        frame.setLayout(new BorderLayout(5,5));

        sloganLabel.setFont(new Font("Serif", Font.BOLD, 150));
        sloganLabel.setForeground(Color.WHITE);
        top.add(sloganLabel);
        top.setBackground(Utility.hexToRGB("#512DA8"));

        frame.add(top, BorderLayout.NORTH);

        mid.setLayout(new BorderLayout(100,100));


        newPlayerButton.setIcon(Utility.scaleIcon(new ImageIcon("src/resources/1466721301_Plus.png"),250,250));
        startButton.setIcon(Utility.scaleIcon(new ImageIcon("src/resources/1466722823_play-triangle-media-shape.png"),250,250));
        mid.add(newPlayerButton, BorderLayout.WEST);
        mid.add(startButton, BorderLayout.EAST);

        frame.add(mid, BorderLayout.CENTER);

        playersLabel.setFont(new Font("Serif", Font.BOLD, 150));
        playersLabel.setForeground(Color.WHITE);
        bottom.add(playersLabel);
        bottom.setBackground(Utility.hexToRGB("#512DA8"));
        frame.add(bottom, BorderLayout.SOUTH);

        buildFrame();

    }

    private void buildFrame() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GameGUI gui = new GameGUI();
    }

}
