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
        elements = new Element[gridRows][gridCols];
        createElements(gridRows, gridCols, panelWidth / gridCols, panelHeight / gridRows);

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

        stack = new Stack<Element>();
    }

    public void createElements(int rows, int cols, int elementWidth, int elementHeight){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                elements[row][col] = new Element(col * elementWidth, row * elementHeight, elementWidth, elementHeight);
            }
        }
    }

    public boolean checkBounds(boolean x, int num, boolean flag){

        if(x){
            if(num < 0 || num > cols-1){
                flag = false;
            }
        }else{
            if(num < 0 || num > rows-1){
                flag = false;
            }
        }
        return flag;
    }

    public void generateMaze(int x, int y){
        stack.push(elements[x][y]);
        while(true){
            if(checkBounds(true, x, true) &&  checkBounds(false, y, true)) {
                if (elements[x][y].isVisited()) {
                    if (stack.empty()) {
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    x = stack.peek().getX();
                    y = stack.peek().getY();
                    elements[x][y].setVisited(true);
                    elements[x][y].setCenter(Color.BLUE);
                    stack.push(elements[x][y]);
                    int random = ThreadLocalRandom.current().nextInt(0, 4);
                    if (random == 0) {
                        x--;
                    }
                    if (random == 1) {
                        x++;
                    }
                    if (random == 2) {
                        y--;
                    }
                    if (random == 3) {
                        y++;
                    }
                }
            }else{
                //out of bounds
            }
        }
    }


//    public void generateMaze(int x, int y){
//
//        if(elements[x][y].isVisited()){
//            stack.pop();
//        }else{
//            stack.push(elements[x][y]);
//            elements[x][y].setVisited(true);
//            elements[x][y].setCenter(Color.BLUE);
//            while(true) {
//                int random = ThreadLocalRandom.current().nextInt(0, 4);
//                if (random == 0) {
//                    try {
//                        if(elements[x - 1][y].isVisited()) {
//                            generateMaze(x - 1, y);
//                            break;
//                        }
//                    } catch (Exception ignore) {}
//                }
//                if (random == 1) {
//                    try {
//                        if(elements[x + 1][y].isVisited()) {
//                            generateMaze(x + 1, y);
//                            break;
//                        }
//                    } catch (Exception ignore) {}
//                }
//                if (random == 2) {
//                    try {
//                        if(elements[x][y - 1].isVisited()) {
//                            generateMaze(x, y - 1);
//                            break;
//                        }
//                    } catch (Exception ignore) {}
//                }
//                if (random == 3) {
//                    try {
//                        if(elements[x][y + 1].isVisited()) {
//                            generateMaze(x, y + 1);
//                            break;
//                        }
//                    } catch (Exception ignore) {}
//                }
//            }
//        }
//
//    }


//    public void generateMaze(int x, int y){
//
//        System.out.println("x: " + x + " y: " + y);
//
//        elements[x][y].setVisited(true);
//
//        if(checkBounds(true, x)){
//            if(checkBounds(false, y)){
//
//                //while(!elements[x-1][y].isVisited()||!elements[x+1][y].isVisited()||!elements[x][y-1].isVisited()||!elements[x][y+1].isVisited()){
//
//                    while(true){
//
//                        int random = ThreadLocalRandom.current().nextInt(0, 4);
//                        if(random == 0){
//                            if(checkBounds(true, x-1)) {
//                                if (!elements[x - 1][y].isVisited()) {
//                                    elements[x - 1][y].setBottom(Color.LIGHT_GRAY);
//                                    elements[x][y].setTop(Color.LIGHT_GRAY);
//                                    generateMaze(x - 1, y);
//                                    break;
//                                }
//                            }
//                        }
//                        if(random == 1){
//                            if(checkBounds(true, x+1)){
//                                if(!elements[x+1][y].isVisited()){
//                                    elements[x+1][y].setTop(Color.LIGHT_GRAY);
//                                    elements[x][y].setBottom(Color.LIGHT_GRAY);
//                                    generateMaze(x+1, y);
//                                    break;
//                                }
//                            }
//                        }
//                        if(random == 2){
//                            if(checkBounds(false, y-1)){
//                                if(!elements[x][y-1].isVisited()) {
//                                    elements[x][y - 1].setRight(Color.LIGHT_GRAY);
//                                    elements[x][y].setLeft(Color.LIGHT_GRAY);
//                                    generateMaze(x, y - 1);
//                                    break;
//                                }
//                            }
//                        }
//                        if(random == 3){
//                            if(checkBounds(false, y+1)){
//                                if(!elements[x][y+1].isVisited()) {
//                                    elements[x][y + 1].setLeft(Color.LIGHT_GRAY);
//                                    elements[x][y].setRight(Color.LIGHT_GRAY);
//                                    generateMaze(x, y + 1);
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                //}
//            }
//        }
//    }

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
