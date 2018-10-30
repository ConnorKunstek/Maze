import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Maze extends JFrame implements ActionListener {

    private Board board;
    private Controls controls;
    private Container c;


    private final int STARTING_DIM = 10;
    private final int BOARD_WIDTH = 10*STARTING_DIM;
    private final int CONTROLS_WIDTH = 200;
    private final int HEIGHT = 10*STARTING_DIM;

    public Maze(){
        super("Maze");
        initialize();
        drawBoard();
        addGenerateActionListener();
        addSolveActionListener();
    }

    public void initialize(){
        controls = new Controls(STARTING_DIM, STARTING_DIM, CONTROLS_WIDTH, HEIGHT);
        board = new Board(controls.getRows(), controls.getCols(), BOARD_WIDTH, HEIGHT);

        c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(controls, BorderLayout.WEST);
        c.add(board, BorderLayout.CENTER);

        this.setSize(BOARD_WIDTH+CONTROLS_WIDTH, HEIGHT);
        this.setVisible(true);
    }

    public void drawBoard(){
        board = new Board(controls.getRows(), controls.getCols(), BOARD_WIDTH, HEIGHT);
        c.add(board, BorderLayout.CENTER);
    }

    ////////////////////////////////////////GENERATE////////////////////////////////////////////////////////////////////

    public void generateMaze(){

    }

    public void addGenerateActionListener(){
        controls.getGenerate().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawBoard();
                //generateMaze();
            }
        });
    }

    ////////////////////////////////////////GENERATE////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////SOLVE///////////////////////////////////////////////////////////////////////

    public void solveMaze(){

    }

    public void addSolveActionListener(){
        controls.getSolve().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(controls.isMazeGenerated()){
                    //solveMaze();
                }else{
                    drawBoard();
                    //generateMaze();
                    //solveMaze();
                }
            }
        });
    }

    ////////////////////////////////////////SOLVE///////////////////////////////////////////////////////////////////////

    public void actionPerformed(ActionEvent e){}

    public static void main(String[] args){
        Maze M = new Maze();
        M.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
