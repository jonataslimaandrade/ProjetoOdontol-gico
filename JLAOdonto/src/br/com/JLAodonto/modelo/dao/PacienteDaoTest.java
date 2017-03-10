package br.com.JLAodonto.modelo.dao;

import br.com.JLAodonto.modelo.entidade.Paciente;
import br.com.JLAodonto.modelo.entidade.SexoType;

public class PacienteDaoTest {

	public static void main(String[] args) {
		
		Paciente paciente = new Paciente("Zé Comeia", "111111111", "87980207300", SexoType.M);
		PacienteDao dao = new PacienteDao();
		dao.inserir(paciente);
	}
}
