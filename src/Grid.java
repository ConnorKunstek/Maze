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

        elements[0][0].setStart(true);
        elements[rows-1][cols-1].setEnd(true);

        for (int i = 0; i < cols; i++) {
            elements[0][i].setTop(Color.BLACK, false);
            elements[rows - 1][i].setBottom(Color.BLACK, false);
        }
        for (int i = 0; i < rows; i++){
            elements[i][0].setLeft(Color.BLACK, false);
            elements[i][cols - 1].setRight(Color.BLACK, false);
        }
    }

    public void createElements(int rows, int cols, int elementWidth, int elementHeight){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                elements[row][col] = new Element(row, col, elementWidth, elementHeight);
                elements[row][col].setStart(false);
                elements[row][col].setEnd(false);
            }
        }
    }
    ////////////////////////////////////////CREATE//////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////SOLVE///////////////////////////////////////////////////////////////////////

    public void solveMaze(int row, int col){
        System.out.println("HERE");
        stack = new Stack<>();
        resetVisited();
        stack.push(elements[row][col]);
        while(stack.peek().getEnd() != true){
            row = stack.peek().getRow();
            col = stack.peek().getCol();
            elements[row][col].setVisited(true);
            elements[row][col].setCenter(Color.GREEN);
            if(checkNeighbors(row, col)){
                while(true){
                    int random = ThreadLocalRandom.current().nextInt(0, 4);
                    if(random == 0 && checkElement(row - 1, col) && elements[row][col].getTop()) {
                        System.out.println("Pushing #0");
                        elements[row][col].setTop(Color.GREEN, true);
                        elements[row - 1][col].setBottom(Color.GREEN, true);
                        stack.push(elements[row - 1][col]);
                        break;
                    }
                    if(random == 1 && checkElement(row + 1, col) && elements[row][col].getBottom()) {
                        System.out.println("Pushing #1");
                        elements[row][col].setBottom(Color.GREEN, true);
                        elements[row + 1][col].setTop(Color.GREEN, true);
                        stack.push(elements[row + 1][col]);
                        break;
                    }
                    if(random == 2 && checkElement(row, col - 1) && elements[row][col].getLeft()) {
                        System.out.println("Pushing #2");
                        elements[row][col].setLeft(Color.GREEN, true);
                        elements[row][col - 1].setRight(Color.GREEN, true);
                        stack.push(elements[row][col - 1]);
                        break;
                    }
                    if(random == 3 && checkElement(row, col + 1) && elements[row][col].getRight()) {
                        System.out.println("Pushing #3");
                        elements[row][col].setRight(Color.GREEN, true);
                        elements[row][col + 1].setLeft(Color.GREEN, true);
                        stack.push(elements[row][col + 1]);
                        break;
                    }
                }
            }else{
                System.out.println("Popping");
                stack.peek().setCenter(Color.PINK);
                if(stack.peek().getBottom()){
                    stack.peek().setBottom(Color.PINK, false);
                }
                if(stack.peek().getTop()){
                    stack.peek().setTop(Color.PINK, false);
                }
                if(stack.peek().getLeft()){
                    stack.peek().setLeft(Color.PINK, false);
                }
                if(stack.peek().getRight()){
                    stack.peek().setRight(Color.PINK, false);
                }
                stack.pop();
            }
        }
    }


    ////////////////////////////////////////SOLVE///////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////GENERATE////////////////////////////////////////////////////////////////////

    public void generateMaze(int row, int col){
        stack = new Stack<>();
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
                        elements[row][col].setTop(Color.LIGHT_GRAY, true);
                        elements[row - 1][col].setBottom(Color.LIGHT_GRAY, true);
                        stack.push(elements[row - 1][col]);
                        break;
                    }
                    if(random == 1 && checkElement(row + 1, col)) {
                        elements[row][col].setBottom(Color.LIGHT_GRAY, true);
                        elements[row + 1][col].setTop(Color.LIGHT_GRAY, true);
                        stack.push(elements[row + 1][col]);
                        break;
                    }
                    if(random == 2 && checkElement(row, col - 1)) {
                        elements[row][col].setLeft(Color.LIGHT_GRAY, true);
                        elements[row][col - 1].setRight(Color.LIGHT_GRAY, true);
                        stack.push(elements[row][col - 1]);
                        break;
                    }
                    if(random == 3 && checkElement(row, col + 1)) {
                        elements[row][col].setRight(Color.LIGHT_GRAY, true);
                        elements[row][col + 1].setLeft(Color.LIGHT_GRAY, true);
                        stack.push(elements[row][col + 1]);
                        break;
                    }
                }
            }else{
                stack.pop();
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
    ////////////////////////////////////////GENERATE////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////OTHER///////////////////////////////////////////////////////////////////////

    public void resetVisited(){
        for(Element[] tempRow: elements){
            for(Element e: tempRow){
                e.setVisited(false);
            }
        }
    }

    ////////////////////////////////////////OTHER///////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////GETTERS AND SETTERS/////////////////////////////////////////////////////////

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
