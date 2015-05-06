package br.com.buildsoft.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.buildsoft.dao.EmpreendimentoDAO;
import br.com.buildsoft.dao.UnidadeDAO;
import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.Empreendimento;
import br.com.buildsoft.domain.Unidade;
import br.com.buildsoft.domain.Usuario;

public class UnidadeDAOtest {

	@Test
	@Ignore
	public void salvar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(1L);

		EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
		Empreendimento empreendimento = empreendimentoDAO.buscarPorCodigo(2L);

		Unidade unidade = new Unidade();

		unidade.setNumeroUnidade("102");
		unidade.setStatus("Disponível");
		unidade.setValor(new BigDecimal(12.35D));
		unidade.setEmpreendimento(empreendimento);

		UnidadeDAO unidadeDAO = new UnidadeDAO();
		unidadeDAO.salvar(unidade);

	}

	/*********************************************************/

	@Test
	@Ignore
	public void buscarPorCodigo() {

		UnidadeDAO unidadeDAO = new UnidadeDAO();
		Unidade unidade = unidadeDAO.buscarPorCodigo(2L);

		System.out.println(unidade);

	}

	/*********************************************************/

	@Test
	@Ignore
	public void listar() {

		UnidadeDAO unidadeDAO = new UnidadeDAO();

		List<Unidade> unidades = unidadeDAO.listar();

		System.out.println(unidades);

	}

	/*********************************************************/

	@Test
	@Ignore
	public void editar() {

		EmpreendimentoDAO empreendimentoDAO = new EmpreendimentoDAO();
		Empreendimento empreendimento = empreendimentoDAO.buscarPorCodigo(1L);

		UnidadeDAO unidadeDAO = new UnidadeDAO();
		Unidade unidade = unidadeDAO.buscarPorCodigo(1L);

		unidade.setEmpreendimento(empreendimento);
		unidade.setNumeroUnidade("301");

		unidadeDAO.editar(unidade);

	}

	/*********************************************************/

	@Test
	@Ignore
	public void excluir() {

		UnidadeDAO unidadeDAO = new UnidadeDAO();

		Unidade unidade = unidadeDAO.buscarPorCodigo(3L);

		unidadeDAO.excluir(unidade);

	}

	/*********************************************************/

}
