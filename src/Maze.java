import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.awt.*;

public class Maze extends JFrame implements ActionListener {

    private Board board;
    private Controls controls;
    private Stats stats;
    private Container c;

    public Maze(){
        super("Maze");
        initialize();
        draw();
    }

    public void initialize(){
        controls = new Controls(50, 50);

        controls.getGenerate().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                draw();
            }
        });

        stats = new Stats();
    }

    public void draw(){
        board = new Board(controls.getRows(), controls.getCols(), 1000, 1000);

        c = getContentPane();
        c.add(controls, BorderLayout.LINE_START);
        c.add(board, BorderLayout.CENTER);
        c.add(stats, BorderLayout.LINE_END);

        this.setSize(1402, 1000);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){}

    public static void main(String[] args){
        Maze M = new Maze();
        M.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }
}
