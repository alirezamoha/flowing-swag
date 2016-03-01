
/**
 * The class <b>GameController</b> is the controller of the game. It implements 
 * the interface ActionListener to be called back when the player makes a move. It computes
 * the next step of the game, and then updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {

 // ADD YOUR INSTANCE VARIABLES HERE
    private int size;
    private GameModel model;
    private GameView view;

     /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */
    public GameController(int size) {
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        this.size = size;
        model = new GameModel(size);
        view = new GameView(model,this);
    }

  
    /**
     * Starts the game
     */
    public void start(){
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        view.setVisible(true);

    }

 
    /**
     * resets the game
     */
    public void reset(){
// REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        view.setVisible(false);
        GameController game = new GameController(size);
        game.start();

    }

    /**
     * Callback used when the user clicks a button or one of the dots. 
     * Implements the logic of the game
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
 // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        System.out.println(((JButton) e.getSource()).getName());
        if ((((JButton) e.getSource()).getName()).equals("Reset")){
            reset();
        }
        if ((((JButton) e.getSource()).getName()).equals("Clear")){
            System.exit(0);
        }
        else{
            for (int i=0; i<size;i++){
                for (int j=0; j<size;j++){
                    if ((((JButton) e.getSource()).getName()).equals(String.valueOf(i)+String.valueOf(j))){
                        if(i == model.getCurrentDot().getX() && j == model.getCurrentDot().getY()){
                            model.setCurrentDot(i,j);

                        }
                        else{
                            model.select(i,j);
                        }
                    }
                }

            }
            view.getBoardView().update();
        }

    }

 
}
