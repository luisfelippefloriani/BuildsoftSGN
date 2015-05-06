package br.com.buildsoft.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import br.com.buildsoft.dao.UsuarioDAO;
import br.com.buildsoft.domain.Usuario;

public class UsuarioDAOtest {

	@Test
	@Ignore
	public void salvar() {

		Usuario usuario = new Usuario();
		usuario.setCpf("863.656.326-73");
		usuario.setNome("Dias Gomes");
		usuario.setSenha("lff99781988");
		usuario.setEmail("diasgomes@gmail.com");
		usuario.setEnderecoLogradouro("Avenida Brasil");
		usuario.setEnderecoNumero("590");
		usuario.setEnderecoBairro("Centro");
		usuario.setEnderecoCidade("Balneário Camboriú");
		usuario.setEnderecoEstado("SC");
		usuario.setTelefoneCel("04796247838");
		usuario.setTipo("corretor");

		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usuario);

	}

	/**************************************************************/

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO dao = new UsuarioDAO();

		List<Usuario> usuarios = dao.listar();

		System.out.println(usuarios);

	}

	/**************************************************************/

	@Test
	@Ignore
	public void excluir() {
		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuario = dao.buscarPorCodigo(7L);

		dao.excluir(usuario);

	}

	/**************************************************************/

	@Test
	@Ignore
	public void editar() {
		UsuarioDAO dao = new UsuarioDAO();

		Usuario usuario = dao.buscarPorCodigo(5L);

		usuario.setNome("Janete Clair");

		dao.editar(usuario);

	}
	
	/**************************************************************/
	
	@Test
	@Ignore
	public void autenticar(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = usuarioDAO.autenticar("065.294.619-49", "lff99781988");
	
		Assert.assertNotNull(usuario);
	}
	
	/**************************************************************/

}
