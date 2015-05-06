package br.com.buildsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.buildsoft.domain.Proposta;
import br.com.buildsoft.util.HibernateUtil;

public class PropostaDAO {

	/*********************************************************************/

	public Long salvar(Proposta proposta) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		Long codigo = null;

		try {
			transacao = sessao.beginTransaction();
			codigo = (Long) sessao.save(proposta);
			transacao.commit();

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();

		}

		return codigo;
	}

	/*********************************************************************/

	@SuppressWarnings("unchecked")
	public List<Proposta> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Proposta> propostas = null;

		try {
			Query consulta = sessao.getNamedQuery("Proposta.listar");
			propostas = consulta.list();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return propostas;
	}

	/*********************************************************************/

	public Proposta buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Proposta proposta = null;

		try {
			Query consulta = sessao.getNamedQuery("Proposta.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			proposta = (Proposta) consulta.uniqueResult();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return proposta;
	}

	/*********************************************************************/

	public void excluir(Proposta proposta) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(proposta);
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

	/*********************************************************************/

	public void editar(Proposta proposta) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(proposta);
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

	/*********************************************************************/

}
