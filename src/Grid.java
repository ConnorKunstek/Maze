import java.awt.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Grid {

    private Element[][] elements;

    private Stack<Element> stack;

    private int rows;
    private int cols;

    public Grid(int gridRows, int gridCols, int panelWidth, int panelHeight) {

        setRows(gridRows);
        setCols(gridCols);
        elements = new Element[rows][cols];
        createElements(rows, cols, panelWidth / cols, panelHeight / rows);

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

        stack = new Stack<>();
    }

    public void createElements(int rows, int cols, int elementWidth, int elementHeight){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                elements[row][col] = new Element(row, col, elementWidth, elementHeight);
            }
        }
    }

    //returns true if there is at least 1 un-visited, in-bounds neighbor
    public boolean checkNeighbors(int row, int col){

        if(row - 1 >= 0){
            if(!elements[row-1][col].isVisited()){
                return true;
            }
        }
        if(row + 1 < rows){
            if(!elements[row+1][col].isVisited()){
                return true;
            }
        }
        if(col - 1 >= 0){
            if(!elements[row][col-1].isVisited()){
                return true;
            }
        }
        if(col + 1 < cols){
            if(!elements[row][col+1].isVisited()){
                return true;
            }
        }
        return false;
    }

    //returns true if given element is un-visited and in-bounds
    public boolean checkElement(int row, int col){
        boolean returnVar = false;
        boolean inBounds = true;

        if(row < 0 || row > rows-1){
            inBounds = false;
        }
        if(col < 0 || col > cols-1){
            inBounds = false;
        }
        if(inBounds){
            returnVar = !elements[row][col].isVisited();
        }
        return returnVar;
    }

    public void mazee(int row, int col){
        elements[row][col].setBottom(Color.LIGHT_GRAY);
        elements[row+1][col].setTop(Color.LIGHT_GRAY);
    }


    public void maze(int row, int col){
        elements[row][col].setVisited(true);
        stack.push(elements[row][col]);
        while(!stack.empty()){
            row = stack.peek().getRow();
            col = stack.peek().getCol();
            elements[row][col].setVisited(true);
            if(checkNeighbors(row, col)){
                while(true){
                    int random = ThreadLocalRandom.current().nextInt(0, 4);
                    if(random == 0 && checkElement(row - 1, col)) {
                        System.out.println(row-1);
                        System.out.println(col);
                        elements[row][col].setTop(Color.LIGHT_GRAY);
                        elements[row - 1][col].setBottom(Color.LIGHT_GRAY);
                        stack.push(elements[row - 1][col]);
                        System.out.println("pushing #0");
                        break;
                    }
                    if(random == 1 && checkElement(row + 1, col)) {
                        System.out.println(row+1);
                        System.out.println(col);
                        elements[row][col].setBottom(Color.LIGHT_GRAY);
                        elements[row + 1][col].setTop(Color.LIGHT_GRAY);
                        stack.push(elements[row + 1][col]);
                        System.out.println("pushing #1");
                        break;
                    }
                    if(random == 2 && checkElement(row, col - 1)) {
                        System.out.println(row);
                        System.out.println(col-1);
                        elements[row][col].setLeft(Color.LIGHT_GRAY);
                        elements[row][col - 1].setRight(Color.LIGHT_GRAY);
                        stack.push(elements[row][col - 1]);
                        System.out.println("pushing #2");
                        break;
                    }
                    if(random == 3 && checkElement(row, col + 1)) {
                        System.out.println(row);
                        System.out.println(col+1);
                        elements[row][col].setRight(Color.LIGHT_GRAY);
                        elements[row][col + 1].setLeft(Color.LIGHT_GRAY);
                        stack.push(elements[row][col + 1]);
                        System.out.println("pushing #3");
                        break;
                    }
                }
            }else{
                System.out.println("popping");
                stack.pop();
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
