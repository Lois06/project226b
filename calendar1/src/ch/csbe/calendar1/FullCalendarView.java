package ch.csbe.calendar1;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;


public class FullCalendarView extends Stage{

    private ArrayList<AnchorPaneNode> allCalendarDays = new ArrayList<>(35);
    private VBox view;
    private Text calendarTitle;
    private YearMonth currentYearMonth;


    /**
     * Erstellt Kalender view
     * 
     */
    
    public FullCalendarView(YearMonth yearMonth) {
        currentYearMonth = yearMonth;
        /**
         * Erstellt Kalender grid pane
         */
        GridPane calendar = new GridPane();
        calendar.setPrefSize(600, 400);
        calendar.setGridLinesVisible(true);
        /**
         * Erstellt rows und columns mit anchorpanes für den Kalender
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                AnchorPaneNode ap = new AnchorPaneNode();
                ap.setPrefSize(200,200);
                calendar.add(ap,j,i);
                allCalendarDays.add(ap);
            }
        }
        /**
         * Tage der Woche Labels
         */
        Text[] dayNames = new Text[]{ new Text("Monday"), new Text("Tuesday"), new Text("Wednesday"),
                                        new Text("Thursday"), new Text("Friday"), new Text("Saturday"),
                                        new Text("Sunday") };
        GridPane dayLabels = new GridPane();
        dayLabels.setPrefWidth(600);
        Integer col = 0;
        for (Text txt : dayNames) {
            AnchorPane ap = new AnchorPane();
            ap.setPrefSize(200, 10);
            ap.setBottomAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            dayLabels.add(ap, col++, 0);
        }
        
        /**
         * Erstellt KalenderTitel und buttons um den Monat zu wechseln
         */
        
        Button choosete = new Button("Back to Choose template ");
        choosete.setOnAction(e -> choosete(e));
       
        calendarTitle = new Text();
        Button previousMonth = new Button("<=");
        previousMonth.setOnAction(e -> previousMonth());
        
        Button nextMonth = new Button("=>");
        nextMonth.setOnAction(e -> nextMonth());
        HBox titleBar = new HBox(previousMonth, calendarTitle, nextMonth);
        titleBar.setAlignment(Pos.BASELINE_CENTER);
        
        ImageView iv1 = new ImageView(Controller.img1);
        ImageView iv2 = new ImageView(Controller.img2);
        
        
       /**
        * Erstellt Kalender mit den nummer Tagen
        */
        populateCalendar(yearMonth);
        
        /**
         * Erstellt den Kalender view
         */
        view = new VBox(titleBar, dayLabels, calendar,choosete,iv1,iv2);
    }

    /**
     * Setzt die Tage im Kalender so das es den Datum korrespondiert
     * 
     */
    public void populateCalendar(YearMonth yearMonth) {
    
    	/**
    	 * Gibt das Datum das man starten will im Kalender
    	 */
        LocalDate calendarDate = LocalDate.of(yearMonth.getYear(), yearMonth.getMonthValue(), 1);
        
        /**
         * Montag ist der erste Tag der Woche
         */
        while (!calendarDate.getDayOfWeek().toString().equals("MONDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        
        /**
         * Publiziert den Kalender mit den Tagen und nummern
         */
        for (AnchorPaneNode ap : allCalendarDays) {
            if (ap.getChildren().size() != 0) {
                ap.getChildren().remove(0);
            }
            Text txt = new Text(String.valueOf(calendarDate.getDayOfMonth()));
            ap.setDate(calendarDate);
            ap.setTopAnchor(txt, 5.0);
            ap.setLeftAnchor(txt, 5.0);
            ap.getChildren().add(txt);
            calendarDate = calendarDate.plusDays(1);
        }

        /**
         * Wechselt den Titel des Kalenders
         */
        calendarTitle.setText(yearMonth.getMonth().toString() + " " + String.valueOf(yearMonth.getYear()));
    }

    /**
     * Button um vom Kalender wieder in das choose.fxml zu gelangen
     * 
     */
    private void choosete(ActionEvent event) {
    	
    	Parent rootchoosete;
		try {
			rootchoosete = FXMLLoader.load(getClass().getResource("choose.fxml"));
			Scene scenechoosete = new Scene(rootchoosete);
	    	Stage stagechoosete = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    	stagechoosete.setTitle("Choose your template");
	    	stagechoosete.centerOnScreen();
	    	stagechoosete.setScene(scenechoosete);
	    	stagechoosete.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
   
    
    /**
     * Wechselt den Monat eins nach hinten, korrekte daten werden gezeigt
     */
    private void previousMonth() {
        currentYearMonth = currentYearMonth.minusMonths(1);
        populateCalendar(currentYearMonth);
    }
    
    /**
     *  Wechselt den Monat eins nach vorne, korrekte daten werden gezeigt
     */
    private void nextMonth() {
        currentYearMonth = currentYearMonth.plusMonths(1);
        populateCalendar(currentYearMonth);
    }

    public VBox getView() {
        return view;
    }

    public ArrayList<AnchorPaneNode> getAllCalendarDays() {
        return allCalendarDays;
    }

    public void setAllCalendarDays(ArrayList<AnchorPaneNode> allCalendarDays) {
        this.allCalendarDays = allCalendarDays;
    }

	
}
