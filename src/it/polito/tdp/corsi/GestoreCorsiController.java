package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import it.polito.tdp.model.Corso;
import it.polito.tdp.model.GestoreCorsi;
import it.polito.tdp.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestoreCorsiController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPeriodo;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnStatCorsi;

    @FXML
    private TextArea txtResult;

    //aggiunto da me
    private GestoreCorsi model;
    
    
    @FXML
    private TextField txtCorso;
    
    
    @FXML
    void doCalcolaStatCorsi(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	int periodo;
    	try {
    		periodo = Integer.parseInt(txtPeriodo.getText());
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	if(periodo != 1 && periodo != 2) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}

    	Map<Corso,Integer> res = model.getIscrittiCorsi(1);

		for(Entry entry : res.entrySet()) {
			txtResult.appendText(((Corso)entry.getKey()).getNome() + "=" + entry.getValue() + "\n");
		}
    	
    	
    }


    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	txtResult.clear();
    	int periodo;
    	try {
    		periodo=Integer.parseInt(txtPeriodo.getText());
    	}catch(NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	
    	if(periodo!=1 && periodo!=2) {
    		txtResult.appendText("Devi inserire un periodo o 1 o 2");
    		return;
    	}
    	
    	
    	List<Corso> corsi=this.model.getCorsiByPeriodo(periodo);
    	for(Corso c: corsi) {
    		txtResult.appendText(c.getNome()+"\n");
    	}
    	
    }

    
    @FXML
    void doCalcolaStatCDS(ActionEvent event) {

    }
    
    
    @FXML
    void doElencaStudenti(ActionEvent event) {

    	txtResult.clear();

    	String codins=txtCorso.getText();
    	
    	if(codins.equals("")) {
    	txtResult.appendText("Devi inserire il codice del corso");
		return;
    	}
    	
    	List<Studente> studenti=this.model.elencaStudenti(codins);
    	
    	if(studenti.isEmpty()) {
        	txtResult.appendText("Devi inserire il codice del corso presente nel database");
    	}
    	
    	for(Studente s: studenti) {
    		txtResult.appendText(s.toString()+"\n");
    	}
    	
    	
    	
    }
    
    
    
    @FXML
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";

    }
    
    
    public void setModel(GestoreCorsi model) {
    	this.model=model;
    }
    
}
