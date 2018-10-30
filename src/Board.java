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

        this.setSize(width, height);

        grid = new Grid(rows, cols, width, height);

        this.setLayout(new GridLayout(rows, cols, 0, 0));

        for(Element[] row: grid.getElements()){
            for(Element e: row){
                this.add(e);
            }
        }
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
