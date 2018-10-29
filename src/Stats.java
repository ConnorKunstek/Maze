import javax.swing.*;
import java.awt.*;

public class Stats extends JPanel{

    private JLabel percent;

    public Stats(){
        super();
        percent = new JLabel("Percent: 0.0%");

        this.add(percent);

        this.setLayout(new GridLayout(1, 1));

        this.setSize(200, 1000);

        this.setVisible(true);

        //this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
}
