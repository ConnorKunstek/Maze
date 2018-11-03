import javax.swing.*;
import java.awt.*;

public class Element extends JPanel{

    private int row;
    private int col;
    private int height;
    private int width;

    private Square[][] squares;

    private boolean visited;

    private boolean top;
    private boolean bottom;
    private boolean left;
    private boolean right;

    private boolean start;
    private boolean end;

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

    public void repaintAll(){
        for(Square[] row: squares){
            for(Square s: row){
                repaint();
            }
        }
    }

    public void setWalls(Color color){
        setTop(color, false);
        setBottom(color, false);
        setLeft(color, false);
        setRight(color, false);
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
    public void setTop(Color color, boolean open){
        squares[0][1].setColor(color);
        squares[0][2].setColor(color);

        top = open;
    }
    public void setBottom(Color color, boolean open){
        squares[3][1].setColor(color);
        squares[3][2].setColor(color);

        bottom = open;
    }
    public void setLeft(Color color, boolean open){
        squares[1][0].setColor(color);
        squares[2][0].setColor(color);

        left = open;
    }
    public void setRight(Color color, boolean open){
        squares[1][3].setColor(color);
        squares[2][3].setColor(color);

        right = open;
    }

    public void setStart(boolean var){
        if(var) {
            setCenter(Color.GREEN);
            start = true;
        }else{
            setCenter(Color.LIGHT_GRAY);
            start = false;
        }
    }

    public void setEnd(boolean var){
        if(var) {
            setCenter(Color.RED);
            end = true;
        }else{
            setCenter(Color.LIGHT_GRAY);
            end = false;
        }
    }

    public boolean getEnd(){
        return this.end;
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

    public boolean getTop(){return this.top;}
    public boolean getBottom(){return this.bottom;}
    public boolean getLeft(){return this.left;}
    public boolean getRight(){return this.right;}

}