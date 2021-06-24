package sample;

import javafx.geometry.Point2D;

import java.util.ArrayList;

public class Board {
    private ArrayList<Piece> pieces = new ArrayList<>();
    private ArrayList<Point2D> highlighted = new ArrayList<>();

    public Board() {
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn(i, 6));
        }
    }

//    public void highlight(int x, int y) {
//        highlighted.add(new Point2D(x, y));
//    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void highlight(int x, int y) {
        highlighted.add(new Point2D(x, y));
    }
}
