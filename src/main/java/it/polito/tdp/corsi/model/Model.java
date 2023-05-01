package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudentiDAO;


public class Model {
	private CorsoDAO corsoDAO;
	private StudentiDAO studentiDAO;
	
	
	
	public Model() {
		this.corsoDAO = new CorsoDAO();
		this.studentiDAO = new StudentiDAO();
	}



	public List<Corso> listCourseByPeriod(int period){
		return corsoDAO.getCorsiByPeriodo(period);
	}
	
	public Map<Corso,Integer> CorsiIscritti(int period){
		return corsoDAO.getCorsiIscritti(period);
	}
	public List<Studente> StudentiCorso (String codins){
		return studentiDAO.getStudentiCorso(codins);
	}
	public Map<String,Integer> getCDSStudentiPerCorso(String codins){
		return studentiDAO.getCDSStudentiPerCorso(codins);
	}
}
