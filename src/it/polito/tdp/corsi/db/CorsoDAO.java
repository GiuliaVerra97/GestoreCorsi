package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import it.polito.tdp.model.Corso;

public class CorsoDAO {
	
	/**
	 * Metodo che restituisce tutti i corsi
	 * @return lista della classe {@link corso}
	 */

	public List<Corso> listAll() {		
		String sql="SELECT * FROM corso ";
		List<Corso> result=new LinkedList<Corso>();
		try {
			Connection conn=ConnectDB.getConnection();	
			PreparedStatement st=conn.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Corso c=new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				result.add(c);
			}
			
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	public List<Corso> listCorsiByPD(int periodo) {
		String sql = "SELECT * FROM corso WHERE pd = ?";
		List<Corso> result = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"),
						rs.getInt("crediti"),
						rs.getString("nome"),
						rs.getInt("pd"));

				result.add(c);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	public Map<Corso, Integer> getIscrittiCorsi(int periodo) {
		
		String sql="SELECT c.codins, c.nome, c.crediti, c.pd,  COUNT(*) AS tot " + 
				"FROM corso as c, iscrizione as i " + 
				"WHERE c.codins=i.codins AND c.pd=? " + 
				"GROUP BY c.nome, c.codins, c.crediti, c.pd ";
		
		Map<Corso, Integer> result=new HashMap<Corso, Integer>();
		
		try {
			
			Connection conn=ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs=st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				result.put(c, rs.getInt("tot"));
			}
			
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		
		return result;
	}

}
