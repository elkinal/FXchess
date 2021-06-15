package sample;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Piece {
    private Point2D position;
    private Point2D moveset;
    private Image image;

    /*
    public Piece(String imagePath, Point2D moveset, Point2D position) {
        this.imagePath = imagePath;
        this.moveset = moveset;
        this.position = position;
    }

     */

    public Piece(Point2D position) {
        this.position = position;
    }

    public Point2D getMoveset() {
        return moveset;
    }

    public void setMoveset(int x, int y) {
        this.moveset = new Point2D(x, y);
    }

    public Point2D getPosition() {
        return position;
    }

    public void setPosition(Point2D position) {
        this.position = position;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return (int) position.getX();
    }

    public int getY() {
        return (int) position.getY();
    }

    public void draw(GraphicsContext g) {
        g.drawImage(getImage(), getX()*100, getY()*100);
    }

    public void drawMoveset(GraphicsContext g) {
        g.setFill(Color.RED);
        g.fillRect((getX()+getMoveset().getX())*100, (getY()+getMoveset().getY())*100, 100, 100);
    }
}
