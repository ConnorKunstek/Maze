import javax.swing.*;

public class Grid {

    private Square[][] squares;

    private int gridRows;
    private int gridCols;

    public Grid(int gridRows, int gridCols, int panelHeight, int panelWidth){
        setGridRows(gridRows);
        setGridCols(gridCols);
        squares = new Square[gridRows][gridCols];
        createSquares(gridRows, gridCols,panelHeight/gridRows, panelWidth/gridCols);
    }

    public void createSquares(int rows, int cols, int squareHeight, int squareWidth){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                squares[row][col] = new Square(row * squareHeight, col * squareWidth, squareHeight, squareWidth);
            }
        }
    }

    public void fillBoard(JPanel board){
        for(Square[] row: squares){
            for(Square s: row){
                board.add(s);
            }
        }
    }

    //Getters and Setters///////////////////////////////////////////////////////////////////////////////////////////////

    //Squares
    public Square[][] getSquares() {return squares;}
    public void setSquares(Square[][] squares) {this.squares = squares;}

    //Grid Rows
    public int getGridRows() {return gridRows; }
    public void setGridRows(int gridRows) {this.gridRows = gridRows; }

    //Grid Cols
    public int getGridCols() {return gridCols; }
    public void setGridCols(int gridCols) {this.gridCols = gridCols; }

}
