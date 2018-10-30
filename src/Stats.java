import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Stats extends JPanel{

    private JLabel percentLabel;

    private int percent;

    public Stats(){
        super();

        percent = 0;

        percentLabel = new JLabel("     Percent: " + Integer.toString(percent) + "%     ");

        percentLabel.setHorizontalAlignment(JLabel.CENTER);

        this.add(percentLabel);

        this.setLayout(new GridLayout(1, 1, 5, 0));

        this.setSize(200, 1000);

        this.setVisible(true);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
}
