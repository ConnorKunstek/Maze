import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.awt.*;

public class Maze extends JFrame implements ActionListener {

    private Board board;
    private Controls controls;
    private Container c;

    public Maze(){
        super("Maze");
        initialize();
        draw();
    }

    public void initialize(){
        controls = new Controls(50, 50);

        controls.getRowSlider().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                draw();
            }
        });
        controls.getColSlider().addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                draw();
            }
        });

        board = new Board(controls.getRows(), controls.getCols(), controls.getCols()*10, controls.getRows()*10);
    }

    public void draw(){
        c = getContentPane();
        c.add(controls, BorderLayout.EAST);
        c.add(board, BorderLayout.WEST);
        setSize(controls.getWidth() + board.getWidth(), controls.getHeight());
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){}

    public static void main(String[] args){
        Maze M = new Maze();
        M.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}