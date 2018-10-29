import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {

    private Grid grid;

    private int height;
    private int width;

    public Board(int rows, int cols, int width, int height){
        super();

        setWidth(width);
        setHeight(height);

        grid = new Grid(rows, cols, width, height);
        grid.fillBoard(this);

        this.setLayout(new GridLayout(rows, cols));

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //Getters and Setters///////////////////////////////////////////////////////////////////////////////////////////////

    //grid
    public Grid getGrid() {return grid;}
    public void setGrid(Grid grid) {this.grid = grid;}

    //Height
    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height;}

    //width
    public int getWidth() {return width;}
    public void setWidth(int width) {this.width = width; }

    public void actionPerformed(ActionEvent e){}
}
