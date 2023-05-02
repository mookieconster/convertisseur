package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SampleController implements Initializable
{

    @FXML
    private Tab tab;

    @FXML
    private ComboBox<String> cboLength;
    
    @FXML
    private ComboBox<String> cboLength1;
    
    @FXML
    private TextField txtLength;

    @FXML
    private TextField txtLength1;
    
    @FXML
    private ComboBox<String> cboWeight;

    @FXML
    private ComboBox<String> cboWeight2;

    @FXML
    private TextField txtWeight;
    
    @FXML
    private TextField txtWeight2;
    
    @FXML
    private ComboBox<String> cboVolume;
    
    @FXML
    private ComboBox<String> cboVolume2;

    @FXML
    private TextField txtVolume;
    
    @FXML
    private TextField txtVolume2;
    
    @FXML
    private ComboBox<String> cboTemps;
    
    @FXML
    private ComboBox<String> cboTemps2;

    @FXML
    private TextField txtTemps;
    
    @FXML
    private TextField txtTemps2;

    //boutton pour quitter le programme
    
    @FXML
    private void quitter()
    {
    	Alert alert=new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("Confirmation");
    	alert.setTitle("Sortie ");
    	alert.setContentText("Veux tu vraiment quitter?");
    	Optional <ButtonType> result=alert.showAndWait();
    	if(result.get()== ButtonType.OK)
    	{
    	System.exit(0);
    	}   
    }
    //calcule des conversions
  //les calculs pour le volume
    private ObservableList<String> listVolume=FXCollections.observableArrayList("Litre", "Millilitre" ,"Gallon", "Cups", "Quart", "Pint", "Tablespoon", "Teaspoon");
    private double []volume= {1.0, 1000, 0.219969, 3.52, 0.879877, 1.76, 56.3121, 168.936};
    
  //les calculs pour le longeur
    private ObservableList<String> listLength=FXCollections.observableArrayList("Metre", "Centimeter", "Millimeter", "Kilometer", "Mile", "Yard", "Foot", "Inch");
    private double []longeur= {1.0, 100, 1000, 0.001, 0.0006213689, 1.0936132983, 3.280839895, 39.37007874}; 
    
  //les calculs pour le poid
    private ObservableList<String> listWeight=FXCollections.observableArrayList("Kilogram", "Gram", "Milligram", "Pound", "Ounce", "Carrat", "Metric Ton", "Long Ton", "Short Ton");
    private double []weight= {1.0, 1000, 1000000, 2.20462, 35.27399, 0.001, 0.0009842073, 0.0011023122};
    
  //Les calculs pour le temps
    private ObservableList<String> listTemps=FXCollections.observableArrayList("Second", "Milisecond", "Minute", "Hour", "Day", "Week", "Year");
    private double []temps= {3600, 3600000, 60, 1.0, 0.0416666667, 0.005952381, 0.0001140771 };
  
 
   
   
    
    @FXML
    private void ConvertL1()
    {
    	convert(cboLength,cboLength1,txtLength,txtLength1,longeur);
    }
    @FXML
    private void ConvertL2()
    {
    	convert(cboLength1,cboLength,txtLength1,txtLength,longeur);
    }
    
    
    @FXML
    private void ConvertW1()
    {
    	convert(cboWeight,cboWeight2,txtWeight,txtWeight2,weight);
    }
    @FXML
    private void ConvertW2()
    {
    	convert(cboWeight2,cboWeight,txtWeight2,txtWeight,weight);
    }
    
    @FXML
    private void ConvertV1()
    {
    	convert(cboVolume,cboVolume2,txtVolume,txtVolume2,volume);
    }
    @FXML
    private void ConvertV2()
    {
    	convert(cboVolume2,cboVolume,txtVolume2,txtVolume,volume);
    }
    @FXML
    private void ConvertT1()
    {
    	convert(cboTemps,cboTemps2,txtTemps,txtTemps2,temps);
    }
    @FXML
    private void ConvertT2()
    {
    	convert(cboTemps2,cboTemps,txtTemps2,txtTemps,temps);
    }
    
    // verifie si c'est un mombre au lieu d'un string
    @FXML
    private void verifNum(KeyEvent e)
    {
    TextField txt=(TextField)e.getSource();

    	txt.textProperty().addListener((observable,oldValue,newValue)->

    	{
    		if(!newValue.matches("^-?[0-9](\\.[0-9]+tonigh)?$"))
    		{
    			txt.setText(newValue.replaceAll("[^\\d*\\.\\-]",""));
    		}
    });
    }
	
    // fonction pour faire les equivalences entres les valeurs en haut
    
    private double setTaux (ComboBox a, double tbl[])
    {
    	int item=a.getSelectionModel().getSelectedIndex();
    	double val=tbl[item];
    	return val;
    }
    // fonction pour convertir les valeurs
    
    private void convert(ComboBox a, ComboBox b, TextField c, TextField d, double tbl[])
    {
    	double from =setTaux(a,tbl);
    	double depart=0;
   
    	if(c.getText().equals(""))
    		depart=0;
    	else
    		depart=Double.parseDouble(c.getText());
    		
    	depart=c.getText().equals(" ")?0:Double.parseDouble(c.getText());
    		double to=setTaux(b,tbl);
    		double dest=(to/from)*depart;
    		d.setText(String.valueOf(dest));
    }
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		cboLength.setItems(listLength);
		
		cboLength.setItems(listLength);
		 cboLength1.setItems(listLength);
				 cboLength.getSelectionModel().selectFirst();
				 cboLength1.getSelectionModel().selectFirst();
				  
				  cboWeight.setItems(listWeight); 
				  cboWeight2.setItems(listWeight);
				 cboWeight.getSelectionModel().selectFirst();
				 cboWeight2.getSelectionModel().selectFirst();
				  
				  cboVolume.setItems(listVolume); 
				  cboVolume2.setItems(listVolume);
				  cboVolume.getSelectionModel().selectFirst();
				  cboVolume2.getSelectionModel().selectFirst();
				 
				  cboTemps.setItems(listTemps); 
				  cboTemps2.setItems(listTemps);
				  cboTemps.getSelectionModel().selectFirst();
				  cboTemps2.getSelectionModel().selectFirst();
				 
				
		
	}
}

 
