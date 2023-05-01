package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Studente;

public class StudentiDAO {
	public List<Studente> getStudentiCorso(String codins){
		String sql = "SELECT s.matricola,s.cognome,s.nome,s.CDS "
				+ "FROM	iscrizione i, studente s "
				+ "WHERE i.matricola=s.matricola and i.codins=?";
		try {
			Connection conn = dbConnect.getConnection();
			PreparedStatement sp = conn.prepareStatement(sql);
			sp.setString(1, codins);
			ResultSet rs= sp.executeQuery();
			
			List<Studente> result = new ArrayList<>();
			while(rs.next()) {
				Studente s= new Studente(rs.getInt("matricola"),rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS")); 
				result.add(s);
			}
			rs.close();
			sp.close();
			conn.close();
			return result;
			
			
			
			
			
		} catch (SQLException e) {
			System.err.println("Errore nella connessione");
			return null;
		}
		
	}
	public Map<String,Integer> getCDSStudentiPerCorso (String codins){
		String sql = "SELECT s.CDS, COUNT(*) AS n "
				+ "FROM	iscrizione i, studente s "
				+ "WHERE i.matricola=s.matricola and i.codins=? AND s.CDS<>'' "
				+ "GROUP BY s.CDS";
		try {
			Connection conn = dbConnect.getConnection();
			PreparedStatement sp = conn.prepareStatement(sql);
			sp.setString(1, codins);
			ResultSet rs= sp.executeQuery();
			
			Map<String,Integer> result = new HashMap<>();
			while(rs.next()) {
				result.put(rs.getString("CDS"), rs.getInt("n"));
			}
			rs.close();
			sp.close();
			conn.close();
			return result;
		
		} catch (SQLException e) {
			System.err.println("Errore nella connessione");
			return null;
		}
		
		
		
		
		
		
		
	}

}
