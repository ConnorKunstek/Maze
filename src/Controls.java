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

    private int speed;

    private JSlider rowSlider;
    private JSlider colSlider;
    private JSlider speedSlider;

    private JLabel title;
    private JLabel rowLabel;
    private JLabel colLabel;
    private JLabel speedLabel;

    private JButton generate;
    private JButton solve;
    private JButton pause;
    private JButton animate;

    private boolean animateFlag;
    private boolean pauseFlag;
    private boolean generatedFlag;
    private boolean generatingFlag;
    private boolean solvedFlag;
    private boolean solvingFlag;

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

        speedSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, 60);
        speedSlider.setValue(60);

        speedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setSpeed(speedSlider.getValue());
            }
        });

        title = new JLabel("Maze Controls");
        title.setHorizontalAlignment(JLabel.CENTER);
        rowLabel = new JLabel("  Rows: ");
        colLabel = new JLabel("  Columns: ");
        speedLabel = new JLabel("  Animation Speed: ");

        generate = new JButton("Generate");
        generate.setAlignmentX(Component.CENTER_ALIGNMENT);

        generatedFlag = false;
        generatingFlag = false;

        generate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generate();
            }
        });

        solve = new JButton("Solve");
        solve.setAlignmentX(Component.CENTER_ALIGNMENT);

        solve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solve();
            }
        });

        pause = new JButton("Unpaused");
        pause.setAlignmentX(Component.CENTER_ALIGNMENT);

        pauseFlag = false;

        pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });

        animate = new JButton("Animating");
        animate.setAlignmentX(Component.CENTER_ALIGNMENT);

        animateFlag = true;

        animate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animate();
            }
        });

        this.setLayout(new GridLayout(11, 1, 0 ,0));

        this.add(title);
        this.add(rowLabel);
        this.add(rowSlider);
        this.add(colLabel);
        this.add(colSlider);
        this.add(generate);
        this.add(solve);
        this.add(pause);
        this.add(animate);
        this.add(speedLabel);
        this.add(speedSlider);

        this.setSize(200, 1000);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        setRows(rows);
        setCols(cols);
        setWidth(202);
    }

    public void solve(){
        if(!isGenerated()){
            generate();
        }
        if(getAnimateFlag()){
            solve.setText("Solving...");
            solvingFlag = true;
            solvedFlag = false;
        }else{
            solved();
        }
    }

    public void solved(){
        solve.setText("Solve");
        solvingFlag = false;
        solvedFlag = true;
    }

    public void generate() {
        if (getAnimateFlag()) {
            generate.setText("Generating...");
            generatingFlag = true;
            generatedFlag = false;
            solve.setEnabled(false);
        }else{
            generated();
        }
    }

    public void generated(){
        generate.setText("Generate");
        generatingFlag = false;
        generatedFlag = true;
        solve.setEnabled(true);
    }

    public void pause(){
        if(pauseFlag){
            pauseFlag = false;
        }else{
            pauseFlag = true;
        }
        if(pauseFlag){
            //pause
            pause.setText("Paused");
        }else{
            //do not pause
            pause.setText("Unpaused");
        }
    }

    public void animate(){
        if(animateFlag){
            animateFlag = false;
        }else{
            animateFlag = true;
        }
        if(animateFlag){
            //animate
            animate.setText("Animating");
            speedLabel.setVisible(true);
            speedSlider.setVisible(true);
        }else{
            //do not animate
            animate.setText("Not Animating");
            speedLabel.setVisible(false);
            speedSlider.setVisible(false);
        }
    }

    //Getters and Setters///////////////////////////////////////////////////////////////////////////////////////////////

    //Rows
    public int getRows() {return rows;}
    public void setRows(int rows) {this.rows = rows;}

    //Cols
    public int getCols() {return cols;}
    public void setCols(int cols) {this.cols = cols;}

    //Speed
    public int getSpeed(){return speed;}
    public void setSpeed(int speed){this.speed = speed; }

    //Height
    public int getHeight() {return 1000;}

    //width
    public int getWidth() {return this.width;}
    public void setWidth(int width){this.width = width;}

    //Get Sliders
    public JSlider getRowSlider() {return rowSlider;}
    public JSlider getColSlider() {return colSlider;}

    public JButton getAnimate() {return animate;}
    public JButton getPause() {return pause;}
    public JButton getSolve() {return solve;}
    public JButton getGenerate() {return generate;}

    public boolean getAnimateFlag(){return animateFlag;}
    public boolean getPauseFlag(){return pauseFlag; }
    public boolean isGenerated(){return generatedFlag;}
    public boolean isGenerating(){return generatingFlag;}
    public boolean isSolved(){return solvedFlag;}
    public boolean isSolving(){return solvingFlag;}

    public void actionPerformed(ActionEvent e){}

}
