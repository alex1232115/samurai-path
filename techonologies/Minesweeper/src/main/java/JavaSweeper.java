import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame {
    private Game game;

    private JPanel panel;
    private JLabel label;

    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;
    private final int BOMBS_COUNT = 10;

    public static void main(String[] args) {
        new JavaSweeper();
    }

    private JavaSweeper () {
        game = new Game(COLS, ROWS, BOMBS_COUNT);
        game.start();
        setImages();
        initLabel();
        initPanel();
        initFrame();
    }

    private void initLabel() {
        label = new JLabel("Welcome");
        add(label, BorderLayout.SOUTH);
    }

    private void initPanel() {
        panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics graphic) {
                super.paintComponent(graphic);
                for (Coord coord: Ranges.getAllCoords()) {
                    graphic.drawImage((Image) game.getBox(coord).image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                if (e.getButton() == MouseEvent.BUTTON1) {
                    game.pressLeftButton(coord);
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    game.pressRightButton(coord);
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    game.start();
                }
                label.setText(getMessage());
                panel.repaint();
            }
        });

        panel.setPreferredSize(new Dimension(Ranges.getSize().x * IMAGE_SIZE, Ranges.getSize().y * IMAGE_SIZE));
        add(panel);
    }

    private String getMessage() {
        return switch (game.getState()) {
            case PLAYED -> "Think twice -_-";
            case BOMBED -> "Try again :( ";
            case WINNER -> "Congratulations :) ";
        };
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
        pack();
        setLocationRelativeTo(null);
    }

    private void setImages() {
        for (Box box: Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    private Image getImage(String name) {
        String fileName = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }
}
