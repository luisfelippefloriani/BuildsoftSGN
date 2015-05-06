package br.com.buildsoft.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.sun.jmx.snmp.Timestamp;

import br.com.buildsoft.dao.AgendaVisitaDAO;
import br.com.buildsoft.dao.EmpreendimentoDAO;
import br.com.buildsoft.dao.InvestidorDAO;
import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.AgendaVisita;
import br.com.buildsoft.domain.Empreendimento;
import br.com.buildsoft.domain.Investidor;
import br.com.buildsoft.domain.Unidade;
import br.com.buildsoft.domain.Usuario;

public class AgendaVisitaDAOtest {

	@Test
	@Ignore
	public void salvar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(1L);

		InvestidorDAO investidorDAO = new InvestidorDAO();
		Investidor investidor = investidorDAO.buscarPorCodigo(1L);

		AgendaVisita agendaVisita = new AgendaVisita();

		agendaVisita.setData(new Date());
		agendaVisita.setDescricao("Cliente Furou");
		agendaVisita.setInvestidor(investidor);
		agendaVisita.setUsuario(usuario);

		AgendaVisitaDAO agendaVisitaDAO = new AgendaVisitaDAO();
		agendaVisitaDAO.salvar(agendaVisita);

	}

	/*********************************************************/

	@Test
	@Ignore
	public void buscarPorCodigo() {

		AgendaVisitaDAO agendaVisitaDAO = new AgendaVisitaDAO();
		AgendaVisita agendaVisita = agendaVisitaDAO.buscarPorCodigo(1L);

		System.out.println(agendaVisita);

	}

	/*********************************************************/

	@Test
	@Ignore
	public void listar() {

		AgendaVisitaDAO agendaVisitaDAO = new AgendaVisitaDAO();

		List<AgendaVisita> agendaVisitas = agendaVisitaDAO.listar();

		System.out.println(agendaVisitas);

	}

	/*********************************************************/

	@Test
	@Ignore
	public void excluir() {

		AgendaVisitaDAO agendaVisitaDAO = new AgendaVisitaDAO();

		AgendaVisita agendaVisita = agendaVisitaDAO.buscarPorCodigo(2L);
		agendaVisitaDAO.excluir(agendaVisita);

	}

	/*********************************************************/

	@Test
	@Ignore
	public void editar() {

		AgendaVisitaDAO agendaVisitaDAO = new AgendaVisitaDAO();

		AgendaVisita agendaVisita = agendaVisitaDAO.buscarPorCodigo(1L);

		agendaVisita.setDescricao("Cliente não apareceu!");

		agendaVisitaDAO.editar(agendaVisita);

	}

}
