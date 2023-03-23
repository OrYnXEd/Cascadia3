import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class BoardGUI extends JPanel {
    private Board board;
    private HashMap<Point, JLabel> tileLabels;
    private HashMap<Point, JLabel> tokenLabels;

    public BoardGUI(Board board) {
        this.board = board;
        this.tileLabels = new HashMap<>();
        this.tokenLabels = new HashMap<>();

        setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(board.getRows(), board.getColumns()));
        add(boardPanel, BorderLayout.CENTER);

        for (int row = 0; row < board.getRows(); row++) {
            for (int col = 0; col < board.getColumns(); col++) {
                Point location = new Point(row, col);
                Tile tile = board.getTileAt(location);
                Token token = board.getTokenAt(location);

                JLabel tileLabel = new JLabel(tile.getImageIcon());
                boardPanel.add(tileLabel);
                tileLabels.put(location, tileLabel);

                if (token != null) {
                    JLabel tokenLabel = new JLabel(token.getImageIcon());
                    tileLabel.add(tokenLabel);
                    tokenLabels.put(location, tokenLabel);
                }
            }
        }
    }
}
