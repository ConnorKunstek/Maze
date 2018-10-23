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

    private int height;
    private int width;

    private JSlider rowSlider;
    private JSlider colSlider;

    public Controls(int rows, int cols, int height, int width){
        super();
        rowSlider = new JSlider(JSlider.VERTICAL, MIN, MAX, rows);
        rowSlider.setValue(rows);

        rowSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setRows(rowSlider.getValue());
            }
        });

        colSlider = new JSlider(JSlider.VERTICAL, MIN, MAX, cols);
        colSlider.setValue(cols);

        colSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setCols(colSlider.getValue());
            }
        });

        add(rowSlider);
        add(colSlider);

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setRows(rows);
        setCols(cols);
        setHeight(height);
        setWidth(width);
    }

    //Getters and Setters///////////////////////////////////////////////////////////////////////////////////////////////

    //Rows
    public int getRows() {return rows;}
    public void setRows(int rows) {this.rows = rows;}

    //Cols
    public int getCols() {return cols;}
    public void setCols(int cols) {this.cols = cols;}

    //Height
    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height;}

    //Width
    public void setWidth(int width) {this.width = width;}
    public int getWidth() {return width;}

    //Get Sliders
    public JSlider getRowSlider() {return rowSlider;}
    public JSlider getColSlider() {return colSlider;}

    public void actionPerformed(ActionEvent e){}

}
