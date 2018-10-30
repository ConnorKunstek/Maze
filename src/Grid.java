import javax.swing.*;

public class Grid {

    private Square[][] squares;

    private int gridRows;
    private int gridCols;

    public Grid(int gridRows, int gridCols, int panelWidth, int panelHeight){
        setGridRows(gridRows);
        setGridCols(gridCols);
        squares = new Square[gridRows][gridCols];
        createSquares(gridRows, gridCols,panelWidth/gridRows, panelHeight/gridCols);
    }

    public void createSquares(int rows, int cols, int squareWidth, int squareHeight){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                squares[row][col] = new Square(col * squareWidth, row * squareHeight, squareWidth, squareHeight);
            }
        }
    }

    public void fillBoard(JPanel board){
        for(int row = 0; row < gridRows; row++){
            for(int col = 0; col < gridCols; col++){
                board.add(squares[row][col]);
            }
        }
    }

    //Getters and Setters///////////////////////////////////////////////////////////////////////////////////////////////

    //Squares
    public Square[][] getSquares() {return squares;}
    //public void setSquares(Square[][] squares) {this.squares = squares;}

    //Grid Rows
    public int getGridRows() {return gridRows; }
    public void setGridRows(int gridRows) {this.gridRows = gridRows; }

    //Grid Cols
    public int getGridCols() {return gridCols; }
    public void setGridCols(int gridCols) {this.gridCols = gridCols; }

}
