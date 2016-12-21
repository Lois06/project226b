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
	
	@FXML 
	protected Button erstellen;
	@FXML
	protected Button create;
	@FXML
	public ImageView image2;
	@FXML
	public ImageView image3;
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
	
	
	
	public void t2() {
		image2.setVisible(true);
		FileChooser fileChooser = new FileChooser();

		// setzt die Filter
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files, (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files, (*.png)", "*.png");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

		// Datei auswählen
		File file = fileChooser.showOpenDialog(null);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			image2.setImage(image);
		} catch (IOException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


	public void t1() {
		image2.setVisible(false);
		FileChooser fileChooser = new FileChooser();

		// setzt die Filter
		FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files, (*.jpg)", "*.JPG");
		FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files, (*.png)", "*.png");
		fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

		// Datei auswählen
		File file = fileChooser.showOpenDialog(null);

		try {
			
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			image1.setImage(image);
		} catch (IOException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void pane1() {
		pane2.setVisible(false);
		paneBildAuswahlZweier.setVisible(false);
		pane1.setVisible(true);
		paneBildAuswahlEinzel.setVisible(true);
		image1.setImage(null);
	}

	public void pane2() {
		pane1.setVisible(false);
		paneBildAuswahlEinzel.setVisible(false);
		pane2.setVisible(true);
		paneBildAuswahlZweier.setVisible(true);
		
	}

	
	
}
