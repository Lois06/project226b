package ch.csbe.calendar1;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;



/**
 * 
 * @author lois.mula
 * erstellt den anchor pane das die daten speichern kann
 *
 */
public class AnchorPaneNode extends AnchorPane {

    // Date associated with this pane
    private LocalDate date;

    
    /**
     * Erstellt ein anchor pane note, es wird aber nicht im konstruktor angezeigt
     * 
     */
    public AnchorPaneNode(Node... children) {
        super(children);
        // Add action handler for mouse clicked
        this.setOnMouseClicked(e -> System.out.println("This pane's date is: " + date));
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

	public void create(Stage stagecreate) {
		// TODO Auto-generated method stub
		
	}
}
