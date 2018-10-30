import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Square extends JComponent {

    private int xpos;
    private int ypos;
    private int height;
    private int width;

    private String type;
    private Color color;

    public Square(int xpos, int ypos, int width, int height){

        super();

        this.setSize(width, height);
        setXpos(xpos);
        setYpos(ypos);
        setWidth(width);
        setHeight(height);
        this.setVisible(true);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(getColor());
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    //color
    public void setColor(Color color){this.color = color; repaint();}
    public Color getColor(){return this.color;}

    //type
    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    //xpos
    public int getXpos() {return xpos;}
    public void setXpos(int xpos) {this.xpos = xpos;}

    //ypos
    public int getYpos() {return ypos; }
    public void setYpos(int ypos) {this.ypos = ypos; }

    //height
    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height;}

    //width
    public int getWidth() {return width;}
    public void setWidth(int width) {this.width = width;}
}
