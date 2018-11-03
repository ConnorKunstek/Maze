import javax.swing.*;
import java.awt.*;

public class Element extends JPanel{

    private int row;
    private int col;
    private int height;
    private int width;

    private Square[][] squares;

    private boolean visited;

    public Element(int row, int col, int width, int height){

        super();

        this.setSize(this.getPreferredSize());
        setRow(row);
        setCol(col);
        setWidth(width);
        setHeight(height);
        setVisited(false);
        this.setVisible(true);

        this.setLayout(new GridLayout(4,4,0,0));

        squares = new Square[4][4];

        for(int tempRow = 0; tempRow < 4; tempRow++){
            for(int tempCol = 0; tempCol < 4; tempCol++){
                squares[tempRow][tempCol] = new Square(tempRow, tempCol, width/4, height/4);
                this.add(squares[tempRow][tempCol]);
            }
        }
        setCorners();
        setCenter(Color.LIGHT_GRAY);
        setWalls(Color.BLACK);
    }

    public void setWalls(Color color){
        setTop(color);
        setBottom(color);
        setLeft(color);
        setRight(color);
    }

    public void setCorners() {
        squares[0][0].setColor(Color.BLACK);
        squares[0][3].setColor(Color.BLACK);
        squares[3][0].setColor(Color.BLACK);
        squares[3][3].setColor(Color.BLACK);
        squares[0][0].setType("corner");
        squares[0][3].setType("corner");
        squares[3][0].setType("corner");
        squares[3][3].setType("corner");
    }

    public void setCenter(Color color){
        squares[1][1].setColor(color);
        squares[1][2].setColor(color);
        squares[2][1].setColor(color);
        squares[2][2].setColor(color);
        squares[1][1].setType("center");
        squares[1][2].setType("center");
        squares[2][1].setType("center");
        squares[2][2].setType("center");
    }
    public void setTop(Color color){
        squares[0][1].setColor(color);
        squares[0][1].setType("top");
        squares[0][2].setColor(color);
        squares[0][2].setType("top");
    }
    public void setBottom(Color color){
        squares[3][1].setColor(color);
        squares[3][2].setColor(color);
    }
    public void setLeft(Color color){
        squares[1][0].setColor(color);
        squares[2][0].setColor(color);
    }
    public void setRight(Color color){
        squares[1][3].setColor(color);
        squares[2][3].setColor(color);
    }

    public Square[][] getSquares(){return this.squares;}
    public Square getSquare(int row, int col){return squares[row][col];}

    public int getRow() {return row;}
    public void setRow(int row) {this.row =row;}

    public int getCol() {return col; }
    public void setCol(int col) {this.col = col; }

    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height;}

    public int getWidth() {return width;}
    public void setWidth(int width) {this.width = width;}

    public boolean isVisited() { return visited; }
    public void setVisited(boolean visited) { this.visited = visited; }

}