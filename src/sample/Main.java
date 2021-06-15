package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.floor;

public class Main extends Application {

    private ArrayList<Piece> pieces = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        pieces.add(new Pawn(2, 2));




        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(800, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawGraphics(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) { //toggle flip-flop or drag
                //Show the position of the tile that is clicked on
                int x = (int) floor(e.getX()/100);
                int y = (int) floor(e.getY()/100);

                System.out.println(x + " " + y);

                //now show the moveset of the piece that is clicked on...
                //Finding the piece that is clicked on
                for (Piece piece : pieces) {
                    if(piece.getPosition().getX() == x &&
                        piece.getPosition().getY() == y) {
                        //show moveset
                        //gc.clearRect(0, 0, 800, 800);
                        //drawGraphics(gc);
                        piece.drawMoveset(gc);
                    }
                }
            }
        };
        canvas.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); //should this be stuck onto the canvas or something else?
    }

    private void drawGraphics(GraphicsContext g) {
        drawBoard(g);
        drawPieces(g);
    }

    private void drawBoard(GraphicsContext g) {
        g.setFill(Color.GREEN);
        g.setStroke(Color.BLUE);
        g.fillRect(0, 0, 100, 100);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j*7) % 2 == 0) g.setFill(Color.BLACK);
                else g.setFill(Color.WHITE);
                g.fillRect(100*i, 100*j, 100*i+100, 100*j+100);
            }
        }
    }

    private void drawPieces(GraphicsContext g) {
        for (Piece piece : pieces) {
            piece.draw(g);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
