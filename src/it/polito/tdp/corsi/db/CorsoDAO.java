package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

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

}
