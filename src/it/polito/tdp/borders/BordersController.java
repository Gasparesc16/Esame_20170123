/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.CountryCount;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtAnno"
    private TextField txtAnno; // Value injected by FXMLLoader

    @FXML // fx:id="boxNazione"
    private ComboBox<?> boxNazione; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    
    public void setModel(Model model) {
    	
    	this.model = model;
    	
    	
    	
    	// In questo caso non va bene creare il grafo qui perchè ho bisogno di conoscere l'anno
    	/*
    	try{
    		
    		model.creaGrafo(anno);
    		
    	} catch(RuntimeException e){
    		
    		txtResult.setText(e.getMessage());
    		
    	}
		*/
		
		
	}

    @FXML
    void doCalcolaConfini(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	try{
        	
    		// 1) Estraggo i dati che mi servono
    		int anno = Integer.parseInt(txtAnno.getText());
    		
    		
    		
    		// 2) Verifica le validità dei dati
    		if(anno < 1816 || anno > 2006){
    			// Se qualcosa va male, ce lo diciamo all'utente e ci rifiutiamo di andare avanti
    			txtResult.setText("Errore: anno inserito non valido");
    			return;
    		}
    		
    		
    		
    		// 3) Chiediamo al Model di effettuare l'operazione
    		
        		model.creaGrafo(anno);
        		
        		List<CountryCount> confinanti = model.getConfinanti();
        
    		
    		
    		// 4) Aggiorna la vista con il risultato dell'operazione in base all'esito delle operazioni
    		for(CountryCount c: confinanti) 
        		txtResult.appendText(c.toString()+"\n");
        	
    		
    		
    	} catch (NumberFormatException e){
    		
    		txtResult.setText(e.getMessage());
    		return;
    	}
    	
    	    	

    }

    @FXML
    void doSimula(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
        assert boxNazione != null : "fx:id=\"boxNazione\" was not injected: check your FXML file 'Borders.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";

    }
}
