import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;


public class Controls extends JPanel implements ActionListener {

    private final int MIN = 10;
    private final int MAX = 60;

    private int rows;
    private int cols;

    private int width;
    private int height;

    private int speed;
    private double percent;

    private JSlider rowSlider;
    private JSlider colSlider;
    private JSlider speedSlider;

    private JLabel title;
    private JLabel rowLabel;
    private JLabel colLabel;
    private JLabel speedLabel;
    private JLabel percentLabel;

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

    ////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////////////////////////

    public Controls(int rows, int cols, int width, int height, boolean flag){
        super();

        //set vars
        setRows(rows);
        setCols(cols);
        setWidth(width);
        setHeight(height);
        setSpeed(100);
        setPercent(0);

        //labels
        title = new JLabel("Maze Controls");
        title.setHorizontalAlignment(JLabel.CENTER);
        percentLabel = new JLabel("  Percent Visited: " + percent + "%");

        //initialize
        initializeRowSlider();
        initializeColSlider();
        initializeGenerate();
        initializeSolve();
        initializePause();
        initializeSpeedSlider();
        initializeAnimate(flag);

        //layout
        this.setLayout(new GridLayout(12, 1, 0 ,0));
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
        this.add(percentLabel);
        this.setSize(getWidth(), getHeight());
        //this.setSize(this.getPreferredSize());
    }
    ////////////////////////////////////////CONSTRUCTOR/////////////////////////////////////////////////////////////////
    ////////////////////////////////////////ROWSLIDER///////////////////////////////////////////////////////////////////

    public void initializeRowSlider(){

        rowLabel = new JLabel("  Rows: " + getRows());

        rowSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, rows);

        rowSlider.setMinorTickSpacing(5);
        rowSlider.setMajorTickSpacing(10);
        rowSlider.setPaintTicks(true);
        rowSlider.setPaintLabels(true);
        rowSlider.setSnapToTicks(true);

        rowSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setRows(rowSlider.getValue());
                rowLabel.setText("  Rows: " + getRows());
            }
        });
    }

    ////////////////////////////////////////ROWSLIDER///////////////////////////////////////////////////////////////////
    ////////////////////////////////////////COLSLIDER///////////////////////////////////////////////////////////////////

    public void initializeColSlider(){

        colLabel = new JLabel("  Columns: " + getCols());

        colSlider = new JSlider(JSlider.HORIZONTAL, MIN, MAX, cols);

        colSlider.setMinorTickSpacing(5);
        colSlider.setMajorTickSpacing(10);
        colSlider.setPaintTicks(true);
        colSlider.setPaintLabels(true);
        colSlider.setSnapToTicks(true);

        colSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setCols(colSlider.getValue());
                colLabel.setText("  Columns: " + getCols());
            }
        });
    }

    ////////////////////////////////////////COLSLIDER///////////////////////////////////////////////////////////////////
    ////////////////////////////////////////GENERATE////////////////////////////////////////////////////////////////////
    public void initializeGenerate(){

        generate = new JButton("Generate");
        generate.setHorizontalAlignment(JButton.CENTER);

        generatedFlag = false;
        generatingFlag = false;

        generate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateMaze();
            }
        });
    }

    public void generateMaze() {
        if(getAnimateFlag()) {
            generate.setText("Generating...");
            generatingFlag = true;
            generatedFlag = false;
            generatedMaze();
        }else{
            generatedMaze();
        }
    }


    public void generatedMaze(){
        generate.setText("Generated");
        generatingFlag = false;
        generatedFlag = true;
    }

    ////////////////////////////////////////GENERATE////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////SOLVE///////////////////////////////////////////////////////////////////////

    public void initializeSolve(){
        solve = new JButton("Solve");
        solve.setAlignmentX(Component.CENTER_ALIGNMENT);

        solve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solveMaze();
            }
        });

    }

    public void solveMaze(){
        if(!isMazeGenerated()){
            generateMaze();
        }
        if(getAnimateFlag()){
            solve.setText("Solving...");
            solvingFlag = true;
            solvedFlag = false;
            solvedMaze();
        }else{
            solvedMaze();
        }
    }

    public void solvedMaze(){
        solve.setText("Solved");
        solvingFlag = false;
        solvedFlag = true;
    }

    ////////////////////////////////////////SOLVE///////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////PAUSE///////////////////////////////////////////////////////////////////////

    public void initializePause(){
        pause = new JButton("Unpaused");
        pause.setAlignmentX(Component.CENTER_ALIGNMENT);

        pauseFlag = false;

        pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pause();
            }
        });
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

    ////////////////////////////////////////PAUSE///////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////ANIMATE/////////////////////////////////////////////////////////////////////

    public void initializeAnimate(boolean flag){
        animate = new JButton("Not Animating");
        animate.setAlignmentX(Component.CENTER_ALIGNMENT);

        animateFlag = flag;

        animate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                animate();
            }
        });
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

    ////////////////////////////////////////ANIMATE/////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////SPEEDSLIDER/////////////////////////////////////////////////////////////////

    public void initializeSpeedSlider() {

        speedLabel = new JLabel("  Animation Speed: " + speed + "%");
        speedLabel.setVisible(false);

        speedSlider = new JSlider(JSlider.HORIZONTAL, 25, 250, 100);

        speedSlider.setMinorTickSpacing(25);
        speedSlider.setMajorTickSpacing(75);
        speedSlider.setPaintTicks(true);
        speedSlider.setPaintLabels(true);
        speedSlider.setSnapToTicks(true);

        speedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                setSpeed(speedSlider.getValue());
                speedLabel.setText("  Animation Speed: " + speed + "%");
            }
        });
    }

    ////////////////////////////////////////SPEEDSLIDER/////////////////////////////////////////////////////////////////
    ////////////////////////////////////////GETTERS AND SETTERS/////////////////////////////////////////////////////////

    public void updatePercent(double counted){

        double total = rows * cols;
        double percent = counted / total;

        percentLabel.setText("  Percent Visited: " + percent + "%");
        this.repaint();
    }

    //Rows
    public int getRows() {return this.rows;}
    public void setRows(int rows) {this.rows = rows;}

    //Cols
    public int getCols() {return this.cols;}
    public void setCols(int cols) {this.cols = cols;}

    //Speed
    public int getSpeed(){return this.speed;}
    public void setSpeed(int speed){this.speed = speed; }

    //percent
    public double getPercent(){return this.percent;}
    public void setPercent(double percent){this.percent = percent;repaint();}

    //Height
    public int getHeight() {return this.height;}
    public void setHeight(int height){this.height = height;}

    //width
    public int getWidth() {return this.width;}
    public void setWidth(int width){this.width = width;}

    //Get Sliders
    public JSlider getRowSlider() {return this.rowSlider;}
    public JSlider getColSlider() {return this.colSlider;}
    public JSlider getSpeedSlider(){return this.speedSlider;}

    //Get JButtons
    public JButton getAnimate() {return this.animate;}
    public JButton getPause() {return this.pause;}
    public JButton getSolve() {return this.solve;}
    public JButton getGenerate() {return this.generate;}

    //Get Flags
    public boolean getAnimateFlag(){return animateFlag;}
    public boolean getPauseFlag(){return pauseFlag; }
    public boolean isMazeGenerated(){return generatedFlag;}
    public boolean isMazeGenerating(){return generatingFlag;}
    public boolean isMazeSolved(){return solvedFlag;}
    public boolean isMazeSolving(){return solvingFlag;}

    //
    public void setIsMazeGenerating(boolean flag){
        this.generatedFlag = flag;
    }

    public void actionPerformed(ActionEvent e){}
}
