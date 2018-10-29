import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class Controls extends JPanel implements ActionListener {

    private final int MIN = 20;
    private final int MAX = 100;

    private int rows;
    private int cols;

    private int width;

    private JSlider rowSlider;
    private JSlider colSlider;

    private JLabel title;
    private JLabel rowLabel;
    private JLabel colLabel;
    private JLabel showAnimate;

    private JButton generate;
    private JButton solve;
    private JButton pause;
    private JButton animate;

    public Controls(int rows, int cols){
        super();
        rowSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, rows);
        rowSlider.setValue(rows);

        rowSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setRows(rowSlider.getValue());
            }
        });

        colSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, cols);
        colSlider.setValue(cols);

        colSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setCols(colSlider.getValue());
            }
        });

        title = new JLabel("Maze Controls");
        title.setHorizontalAlignment(JLabel.CENTER);
        rowLabel = new JLabel("Rows: ");
        colLabel = new JLabel("Columns: ");
        showAnimate = new JLabel("Animate: ");

        generate = new JButton("Generate");
        generate.setAlignmentX(Component.CENTER_ALIGNMENT);
        //generate.setPreferredSize(new Dimension(getWidth()-2, getHeight()/10));
        solve = new JButton("Solve");
        solve.setAlignmentX(Component.CENTER_ALIGNMENT);
        //solve.setPreferredSize(new Dimension(getWidth()-2, getHeight()/10));
        pause = new JButton("Pause");
        pause.setAlignmentX(Component.CENTER_ALIGNMENT);
        //pause.setPreferredSize(new Dimension(getWidth()-2, getHeight()/10));
        animate = new JButton("Animate");
        animate.setAlignmentX(Component.CENTER_ALIGNMENT);
        //animate.setPreferredSize(new Dimension(getWidth()-2, getHeight()/10));

        this.setLayout(new GridLayout(9, 1, 0 ,0));

        this.add(title);
        this.add(rowLabel);
        this.add(rowSlider);
        this.add(colLabel);
        this.add(colSlider);
        this.add(generate);
        this.add(solve);
        this.add(pause);
        this.add(animate);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setRows(rows);
        setCols(cols);
        setWidth(200);
    }

    //Getters and Setters///////////////////////////////////////////////////////////////////////////////////////////////

    //Rows
    public int getRows() {return rows;}
    public void setRows(int rows) {this.rows = rows;}

    //Cols
    public int getCols() {return cols;}
    public void setCols(int cols) {this.cols = cols;}

    //Height
    public int getHeight() {return getRows()*10;}

    //width
    public int getWidth() {return this.width;}
    public void setWidth(int width){this.width = width;}

    //Get Sliders
    public JSlider getRowSlider() {return rowSlider;}
    public JSlider getColSlider() {return colSlider;}

    public void actionPerformed(ActionEvent e){}

}
