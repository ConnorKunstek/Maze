import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends JComponent {

    //private Graphics square;
    //private BufferedImage tempImage;

    private int xpos;
    private int ypos;
    private int height;
    private int width;

    public Square(int xpos, int ypos, int width, int height){

        setSize(width, height);
        setXpos(xpos);
        setYpos(ypos);
        setWidth(width);
        setHeight(height);
        setVisible(true);
        setBackground(Color.RED);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.fillRect(getXpos(), getYpos(), getWidth(), getHeight());
        g.setColor(Color.RED);
    }

    public int getXpos() {return xpos;}
    public void setXpos(int xpos) {this.xpos = xpos;}

    public int getYpos() {return ypos; }
    public void setYpos(int ypos) {this.ypos = ypos; }

    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height;}

    public int getWidth() {return width;}
    public void setWidth(int width) {this.width = width;}

//    public Graphics getSquare() {return square;}
//    public void setSquare(Graphics square) {this.square = square;}

}
