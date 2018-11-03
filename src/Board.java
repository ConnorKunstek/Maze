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

        this.setSize(this.getPreferredSize());

        grid = new Grid(rows, cols, width, height);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        Element[][] elements = grid.getElements();

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                gbc.gridx = col;
                gbc.gridy = row;
                this.add(elements[row][col], gbc);
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
