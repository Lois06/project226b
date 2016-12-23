package ch.csbe.calendar1;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.YearMonth;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	public static Image img1;
	public static Image img2;
	@FXML 
	protected Button erstellen;
	@FXML
	protected Button create;
	@FXML
	protected Button exit;
	@FXML
	protected Button yes;
	@FXML
	protected Button no;
	@FXML
	protected Button back;
	@FXML
	public ImageView image2;
	@FXML
	public ImageView image1;
	@FXML
	public Pane pane1;
	@FXML
	public Pane pane2;
	@FXML
	public Pane paneBildAuswahlEinzel;
	@FXML
	public Pane paneBildAuswahlZweier;
    @FXML 
    public Pane calendarPane;
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	/**
	 * 
	 * Button um in die Choose.fxml datei zu gelangen
	 * 
	 */
	@FXML
	protected void erstellen(ActionEvent event) throws Exception{
	

	Parent rooterstellen = FXMLLoader.load(getClass().getResource("choose.fxml"));
	Scene sceneerstellen = new Scene(rooterstellen);
	Stage stageerstellen = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stageerstellen.setTitle("Choose your template");
	stageerstellen.centerOnScreen();
	stageerstellen.setScene(sceneerstellen);
	stageerstellen.show();
	
	}
	
	/**
	 * Button um den Kalender zu erstellen
	 */
	
	@FXML
	protected void create(ActionEvent event) throws Exception{
	
	Stage stagecreate = (Stage) ((Node) event.getSource()).getScene().getWindow();
	//FullCalendarView f = new FullCalendarView();
	//f.create(stagecreate);
	//Parent rootcreate = FXMLLoader.load(getClass().getResource()); //"FullCalendarView.java"
	//Scene scenecreate = new Scene(rootcreate);
	stagecreate.setTitle("Kalender");
	stagecreate.centerOnScreen();
	stagecreate.setScene(new Scene((new FullCalendarView(YearMonth.now())).getView()));
	stagecreate.show();
	
	}
	
	/**
	 * Button um ins Exit.fxml zu gelangen
	 */
	
	@FXML
	protected void exit(ActionEvent event) throws Exception{
	
	Parent rootexit = FXMLLoader.load(getClass().getResource("exit.fxml"));
	Scene sceneexit = new Scene(rootexit);
	Stage stageexit = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stageexit.setTitle("exit");
	stageexit.centerOnScreen();
	stageexit.setScene(sceneexit);
	stageexit.show();
	
	}
	
	/**
	 * Button um das Programm schliessen zu können
	 */
	
	@FXML
	protected void yes(ActionEvent event) throws Exception{
		System.exit(0);
	}
	
	/**
	 * Button um das Programm nicht schliessen zu müssen
	 */
	@FXML
	protected void no(ActionEvent event) throws Exception{
	
	Parent rootno = FXMLLoader.load(getClass().getResource("start.fxml"));
	Scene sceneno = new Scene(rootno);
	Stage stageno = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stageno.setTitle("Create your calendar");
	stageno.centerOnScreen();
	stageno.setScene(sceneno);
	stageno.show();
	
	}
	
	/**
	 * Button um zurück ins Menü zu gelangen
	 */
	@FXML
	protected void back(ActionEvent event) throws Exception{
	
	Parent rootback = FXMLLoader.load(getClass().getResource("start.fxml"));
	Scene sceneback = new Scene(rootback);
	Stage stageback = (Stage) ((Node) event.getSource()).getScene().getWindow();
	stageback.setTitle("Create your calendar");
	stageback.centerOnScreen();
	stageback.setScene(sceneback);
	stageback.show();
	
	}
	
	/**
	 * Button um Template 2 zu erstellen
	 * 
	 */
	
	public void t2() {
		image2.setVisible(true);
		FileChooser fileChooser = new FileChooser();

		/**
		 *  setzt die Filter
		 */
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files, (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files, (*.png)", "*.png");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

		/**
		 *  Datei auswählen
		 */
		File file = fileChooser.showOpenDialog(null);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			image2.setImage(image);
			img2=image;
		} catch (IOException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
	
		
	}

/**
 * Button um Template 1 zu erstellen
 */
	
	public void t1() {
		image2.setVisible(false);
		FileChooser fileChooser = new FileChooser();

		/**
		 *  setzt die Filter
		 */
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files, (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files, (*.png)", "*.png");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

		/**
		 *  Datei auswählen
		 */
		File file = fileChooser.showOpenDialog(null);

		try {
			
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			image1.setImage(image);
			img1=image;
		} catch (IOException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
		
	}

	/**
	 * Pane 1 hier wird das Bild erste bild angezeigt
	 */
	public void pane1() {
		pane2.setVisible(false);
		paneBildAuswahlZweier.setVisible(false);
		pane1.setVisible(true);
		paneBildAuswahlEinzel.setVisible(true);
		image1.setImage(null);
	}
	
	/**
	 * Pane 2 hier wird das zweite Bild angezeigt
	 */

	public void pane2() {
		pane1.setVisible(false);
		paneBildAuswahlEinzel.setVisible(false);
		pane2.setVisible(true);
		paneBildAuswahlZweier.setVisible(true);
		
	}
	
	
}
