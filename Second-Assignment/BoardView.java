/**
 * The class <b>BoardView</b> provides the current view of the board. It extends
 * <b>JPanel</b> and lays out a two dimensional array of <b>DotButton</b> instances.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;

public class BoardView extends JPanel {

     // ADD YOUR INSTANCE VARIABLES HERE
    private GameModel model;
    private GameController controller;
    private DotButton[][] buttonArray;
    private JPanel panel;



	/**
     * Constructor used for initializing the board. The action listener for
     * the board's DotButton is the game controller
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public BoardView(GameModel gameModel, GameController gameController) {
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        this.model = gameModel;
        this.controller = gameController;
        buttonArray = new DotButton[model.getSize()][model.getSize()];
        for(int i=0; i<model.getSize();i++){
            panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
            panel.setBackground(Color.WHITE);
            if (i%2 == 0){
                Color background = panel.getBackground();
                panel.setBorder(BorderFactory.createMatteBorder(0,0,0,20,Color.WHITE));
            }
            else{
                panel.setBorder(BorderFactory.createMatteBorder(0,20,0,0,Color.WHITE));
            }
            for(int j=0; j<model.getSize();j++){
                int state = model.getCurrentStatus(i,j);
                buttonArray[i][j] = new DotButton(i,j,state);
                buttonArray[i][j].setName(String.valueOf(i) + String.valueOf(j));
                buttonArray[i][j].setBorderPainted(false);
                buttonArray[i][j].addActionListener(controller);
                panel.add(buttonArray[i][j]);
            this.add(panel,BorderLayout.CENTER);

            }
        }
    }

 	/**
	 * update the status of the board's DotButton instances based on the current game model
	 */

    public void update(){
  // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        for(int i=0; i<model.getSize();i++){
            for(int j=0; j<model.getSize();j++){
                buttonArray[i][j].setType(model.getCurrentStatus(i,j));
            }
        } 
        panel.repaint();
	}

}
