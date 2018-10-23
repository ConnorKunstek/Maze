import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {

    private Grid grid;

    private int height;
    private int width;

    public Board(int rows, int cols, int boardHeight, int boardWidth){
        super();

        setHeight(boardHeight);
        setWidth(boardWidth);

        grid = new Grid(rows, cols, boardHeight, boardWidth);
        grid.fillBoard(this);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //Getters and Setters///////////////////////////////////////////////////////////////////////////////////////////////

    //grid
    public Grid getGrid() {return grid;}
    public void setGrid(Grid grid) {this.grid = grid;}

    //Height
    public int getHeight() {return height;}
    public void setHeight(int boardHeight) {this.height = height;}

    //width
    public int getWidth() {return width;}
    public void setWidth(int width) {this.width = width; }

    public void actionPerformed(ActionEvent e){}
}
