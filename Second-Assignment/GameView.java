
/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out an instance of  <b>BoardView</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;

public class GameView extends JFrame {

 // ADD YOUR INSTANCE VARIABLES HERE
    private GameModel model;
    private GameController controller;
    private JButton reset;
    private JButton quit;
    private JPanel panel;
    private BoardView view;
 
    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel model, GameController gameController) {
        super("GameView");
        this.model = model;
        this.controller = gameController;
        view = new BoardView(model,controller);
        panel = new JPanel();
        reset = new JButton("Reset");
        reset.setName("Reset");
        quit = new JButton("Quit");
        quit.setName("Clear");

        // Define the main frame
        this.add(view,BorderLayout.CENTER);
        this.setSize(model.getSize()*50,model.getSize()*50 + 40);
        this.setResizable(false);
        panel.setBackground(Color.WHITE);
        view.setBackground(Color.WHITE);

        //Adding Actions
        reset.addActionListener(controller);
        quit.addActionListener(controller);

        //Add everything to the view
        panel.add(reset);
        panel.add(quit);
        add(panel,BorderLayout.SOUTH);

    }

   /**
     * Getter method for the attribute board.
     * 
     * @return a reference to the BoardView instance
     */

    public BoardView getBoardView(){
 // REPLACE THE BODY OF THIS METHOD WITH YOUR OWN IMPLEMENTATION
        return view;
   }

}
