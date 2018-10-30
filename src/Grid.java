import java.awt.*;

public class Grid {

    private Element[][] elements;

    private int rows;
    private int cols;

    public Grid(int gridRows, int gridCols, int panelWidth, int panelHeight) {
        setRows(gridRows);
        setCols(gridCols);
        elements = new Element[gridRows][gridCols];
        createElements(gridRows, gridCols, panelWidth / gridRows, panelHeight / gridCols);

        elements[0][0].setCenter(Color.GREEN);
        elements[rows - 1][cols - 1].setCenter(Color.RED);

        for (int i = 0; i < cols; i++) {
            elements[0][i].setTop(Color.BLACK);
            elements[rows - 1][i].setBottom(Color.BLACK);
        }
        for (int i = 0; i < rows; i++){
            elements[i][0].setLeft(Color.BLACK);
            elements[i][cols - 1].setRight(Color.BLACK);
        }
    }

    public void createElements(int rows, int cols, int elementWidth, int elementHeight){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                elements[row][col] = new Element(col * elementWidth, row * elementHeight, elementWidth, elementHeight);
            }
        }
    }

    //Getters and Setters///////////////////////////////////////////////////////////////////////////////////////////////

    //Elements
    public Element[][] getElements() {return elements;}
    //public void setElements(Element[][] elements) {this.elements = elements;}

    //Grid Rows
    public int getRows() {return this.rows; }
    public void setRows(int rows) {this.rows = rows; }

    //Grid Cols
    public int getCols() {return this.cols; }
    public void setCols(int cols) {this.cols = cols; }

}
