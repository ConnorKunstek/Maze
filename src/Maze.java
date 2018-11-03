import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Maze extends JFrame implements ActionListener {

    //Classes
    private Board board;
    private Controls controls;

    private Container c;

    //Global values
    private final int STARTING_DIM = 20;
    private final int CONTROLS_WIDTH = 200;

    //timing
    private ActionListener timerListener;
    private Timer timer;
    private int secondsPassed;

    public Maze(){
        super("Maze");
        initialize();
        addGenerateActionListener();
        addSolveActionListener();
    }

    public void initialize(){
        controls = new Controls(STARTING_DIM, STARTING_DIM, CONTROLS_WIDTH, determineDim(STARTING_DIM), true);
        board = new Board(controls.getRows(), controls.getCols(), determineDim(STARTING_DIM), determineDim(STARTING_DIM));

        c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(controls, BorderLayout.WEST);
        c.add(board, BorderLayout.CENTER);

        this.setSize(determineDim(STARTING_DIM)+CONTROLS_WIDTH, determineDim(STARTING_DIM));
        this.setVisible(true);


        timerListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                secondsPassed++;
            }
        };
        timer = new Timer(controls.getSpeed(), timerListener);
    }

    public int determineDim(int dim){
        if(dim < 21){
            return dim * 44;
        }else {
            if (dim < 36){
                return dim * 28;
            }else{
                if(dim < 51) {
                    return dim * 20;
                }else{
                    return dim * 16;
                }
            }
        }
    }

    public void drawBoard(){

        boolean flag = controls.getAnimateFlag();
        int rows = controls.getRows();
        int cols = controls.getCols();
        int newWidth = determineDim(cols);
        int newHeight = determineDim(rows);

        c.removeAll();
        controls = new Controls(rows, cols, CONTROLS_WIDTH, newHeight, flag);
        controls.revalidate();
        controls.repaint();
        board = new Board(rows, cols, newWidth, newHeight);
        board.revalidate();
        board.repaint();
        c.add(controls, BorderLayout.WEST);
        c.add(board, BorderLayout.CENTER);
        this.setSize(board.getWidth()+controls.getWidth(), controls.getHeight());

        addGenerateActionListener();
        addSolveActionListener();
    }

    ////////////////////////////////////////GENERATE////////////////////////////////////////////////////////////////////

    public void addGenerateActionListener(){
        controls.getGenerate().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawBoard();
                board.getGrid().generateMaze(0, 0);
            }
        });
    }

    ////////////////////////////////////////GENERATE////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////SOLVE///////////////////////////////////////////////////////////////////////

    public void addSolveActionListener(){
        controls.getSolve().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                board.getGrid().solveMaze(0 , 0);
                controls.updatePercent(board.getGrid().getCounter());
                controls.getSolve().setText("Solved");
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
