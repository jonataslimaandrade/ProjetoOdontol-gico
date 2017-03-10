package br.com.JLAodonto.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.JLAodonto.modelo.entidade.Paciente;

public class PacienteDao {

	public void inserir(Paciente paciente) {
		
		Connection conn = null;
		Statement stm = null;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");

			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/jlaOdonto", "app", "app");
			stm = conn.createStatement();
			stm.executeUpdate("insert into paciente (nome, rg, cpf, sexo) values "
					+ "('"+ paciente.getNome()
					+ "','"+ paciente.getRg()
					+ "', '" + paciente.getCpf()
					+ "', '" + paciente.getSexo()
					+ "')");
			
		} catch (ClassNotFoundException e) {
			// TODO Remover esta bomba depois isso nao eh legal
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Remover isso do codigo implementar mecanismo de exception handling
			e.printStackTrace();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
