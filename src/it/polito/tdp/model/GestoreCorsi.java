package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;

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
	}

}
