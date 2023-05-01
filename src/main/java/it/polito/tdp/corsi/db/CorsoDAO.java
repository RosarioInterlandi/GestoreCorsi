package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {
	
	public List<Corso> getCorsiByPeriodo(int periodo){
		try {
			String sql = "SELECT codins,crediti,nome,pd "
					+ "FROM corso "
					+ "WHERE corso.pd=?";
			Connection conn = dbConnect.getConnection();
			PreparedStatement sp = conn.prepareStatement(sql);
			sp.setInt(1, periodo);
			ResultSet rs = sp.executeQuery();
			
			List<Corso> result = new ArrayList<Corso>();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				result.add(c);
			}
			rs.close();
			sp.close();
			conn.close();
			
			return result;
			
		} catch (SQLException e) {
			return null;
		}
	}

	public Map<Corso, Integer> getCorsiIscritti(int periodo){
		String sql = "SELECT c.codins,c.crediti,c.nome,c.pd, COUNT(*) n "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins=i.codins and c.pd=? "
				+ "GROUP BY c.codins,c.crediti,c.nome,c.pd";
		try {
			Connection conn = dbConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs=st.executeQuery();
			
			Map<Corso,Integer> result = new HashMap<>();
			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				result.put(c, rs.getInt("n"));
			}
			rs.close();
			st.close();
			conn.close();
			return result;
			
			
			
			
		} catch (SQLException e) {
			return null;
			
		}
		
	}
}
