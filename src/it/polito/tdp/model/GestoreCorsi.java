package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

//è la classe model
public class GestoreCorsi {

	
	/**
	 * Metodo che permette di trovare tutti i corsi di un determinato periodo
	 * @param periodo di insegnamento 
	 * @return lista dei corsi che si svolgono nel periodo didattico richiesto
	 */
	
	public List<Corso> getCorsiByPeriodo(int periodo) {
		
		CorsoDAO dao=new CorsoDAO();
		List<Corso> corsi=dao.listAll();
		List<Corso> result =new ArrayList<Corso>();
		for(Corso c:corsi) {
			if(c.getPd()==periodo) {
				result.add(c);
			}
		}
		return result;
		//possiamo anche usare il metodo: return dao.listCorsiByPD
	}

	
	/**
	 * Metodo che dato un periodo restituisce il numero totale di iscritti ai corsi di quel periodo
	 * @param periodo
	 * @return mappa di corsi con chiave il corso e valore il num tot di iscritti
	 */
	public Map<Corso, Integer> getIscrittiCorsi(int periodo){
		CorsoDAO dao=new CorsoDAO();
		return dao.getIscrittiCorsi(periodo);
	}


	/**
	 * Restituisce gli studenti iscritti ad un corso
	 * @param codins
	 * @return studenti
	 */
	public List<Studente> elencaStudenti(String codins) {
		
		StudenteDAO dao=new StudenteDAO();
		return dao.elencaStudenti(codins);
	}
	
	
}
