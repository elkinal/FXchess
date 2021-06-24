package sample;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Pawn extends Piece {



    public Pawn(int x, int y) {
        super(new Point2D(x, y));
        setMoveset(new Point2D[]{
                new Point2D(0, 1)
        });
        //Load the piece image
        try {
            setImage(new Image(new FileInputStream("C:\\Users\\Elkin\\Downloads\\pawn.png")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Create the piece moveset
//        setMoveset(0, 1);
    }

}
