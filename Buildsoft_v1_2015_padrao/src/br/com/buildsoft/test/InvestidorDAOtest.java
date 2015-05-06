package br.com.buildsoft.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.buildsoft.dao.EmpreendimentoDAO;
import br.com.buildsoft.dao.InvestidorDAO;
import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.Empreendimento;
import br.com.buildsoft.domain.Investidor;
import br.com.buildsoft.domain.Usuario;

public class InvestidorDAOtest {

	@Test
	@Ignore
	public void salvar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(1L);

		Investidor investidor = new Investidor();

		investidor.setNome("Eike Batista");
		investidor.setTipoPessoa("física");
		investidor.setRamoProfissional("Empresário");
		investidor.setTelefoneCelular("011992212345");
		investidor.setEmail("eike@grupox.com.br");

		investidor.setUsuario(usuario);

		InvestidorDAO investidorDAO = new InvestidorDAO();
		investidorDAO.salvar(investidor);

	}

	/*****************************************************************/

	@Test
	@Ignore
	public void buscarPorCodigo() {

		InvestidorDAO investidorDAO = new InvestidorDAO();
		Investidor investidor = investidorDAO.buscarPorCodigo(2L);

		System.out.println(investidor);

	}

	/*****************************************************************/

	@Test
	@Ignore
	public void listar() {

		InvestidorDAO investidorDAO = new InvestidorDAO();

		List<Investidor> investidores = investidorDAO.listar();

		System.out.println(investidores);

	}

	/*****************************************************************/

	@Test
	@Ignore
	public void excluir() {

		InvestidorDAO investidorDAO = new InvestidorDAO();

		Investidor investidor = investidorDAO.buscarPorCodigo(2L);

		investidorDAO.excluir(investidor);

	}

	/*****************************************************************/

	@Test
	@Ignore
	public void editar() {

		InvestidorDAO investidorDAO = new InvestidorDAO();

		Investidor investidor = investidorDAO.buscarPorCodigo(1L);

		investidor.setNome("Eike João Batista");

		investidorDAO.editar(investidor);

	}

}
