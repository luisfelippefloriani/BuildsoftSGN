package br.com.buildsoft.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.buildsoft.dao.EmpreendimentoDAO;
import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.Empreendimento;
import br.com.buildsoft.domain.Usuario;


public class EmpreendimentoDAOtest {

	@Test
	@Ignore
	public void salvar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(1L);

		Empreendimento empreendimento = new Empreendimento();

		empreendimento.setNome("Mikonos");
		empreendimento.setEnderecologradouro("Avenida Atlântica");
		empreendimento.setEnderecoNumero("1260");
		empreendimento.setEnderecoBairro("Centro");
		empreendimento.setEnderecoCidade("Balneário Camboriú");
		empreendimento.setEnderecoEstado("SC");

		empreendimento.setUsuario(usuario);

		EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
		empreendimentoDAO.salvar(empreendimento);

	}

	/*****************************************************************/

	@Test
	@Ignore
	public void buscarPorCodigo() {
		EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
		Empreendimento empreendimento = empreendimentoDAO.buscarPorCodigo(1L);

		System.out.println(empreendimento);

	}

	/*****************************************************************/

	@Test
	@Ignore
	public void listar() {
		EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();

		List<Empreendimento> empreendimentos = empreendimentoDAO.listar();

		System.out.println(empreendimentos);

	}

	/*****************************************************************/

	@Test
	@Ignore
	public void excluir() {
		EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();

		Empreendimento empreendimento = empreendimentoDAO.buscarPorCodigo(3L);

		empreendimentoDAO.excluir(empreendimento);
	}

	/*****************************************************************/

	@Test
	@Ignore
	public void editar() {
		EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();

		Empreendimento empreendimento = empreendimentoDAO.buscarPorCodigo(2L);

		empreendimento.setNome("Mikonos");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(1L);
		empreendimento.setUsuario(usuario);

		empreendimentoDAO.editar(empreendimento);

	}
	
	/*****************************************************************/

}
