package ch.csbe.calendar1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


 /**
  * 
  * @author lois.mula
  * Startet start.fxml
  *
  */
public class Main extends Application {


		@Override
		public void start(Stage primaryStage) throws Exception{
			Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Create your calendar");
			primaryStage.centerOnScreen();
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		public static void main(String[] args) {
	        launch(args);
	    }
}
		
	
