package br.com.buildsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.buildsoft.domain.Unidade;
import br.com.buildsoft.util.HibernateUtil;

public class UnidadeDAO {

	/**********************************************************************/

	public void salvar(Unidade unidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(unidade);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();

		}
	}

	/************************************************************/

	@SuppressWarnings("unchecked")
	public List<Unidade> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Unidade> unidades = null;

		try {
			Query consulta = sessao.getNamedQuery("Unidade.listar");
			unidades = consulta.list();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return unidades;
	}

	/************************************************************/

	public Unidade buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Unidade unidade = null;

		try {
			Query consulta = sessao.getNamedQuery("Unidade.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			unidade = (Unidade) consulta.uniqueResult();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return unidade;
	}

	/************************************************************/

	public void excluir(Unidade unidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(unidade);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();

		}

	}

	/************************************************************/

	public void editar(Unidade unidade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(unidade);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();

		}

	}

	/************************************************************/

}
