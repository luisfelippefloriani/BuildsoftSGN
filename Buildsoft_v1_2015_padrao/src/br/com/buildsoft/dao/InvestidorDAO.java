package br.com.buildsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.buildsoft.domain.Investidor;
import br.com.buildsoft.util.HibernateUtil;

public class InvestidorDAO {

	/**********************************************************************/

	public void salvar(Investidor investidor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(investidor);
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

	/**************************************************************/

	@SuppressWarnings("unchecked")
	public List<Investidor> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Investidor> investidores = null;

		try {
			Query consulta = sessao.getNamedQuery("Investidor.listar");
			investidores = consulta.list();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return investidores;
	}

	/**************************************************************/

	public Investidor buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Investidor investidor = null;

		try {
			Query consulta = sessao.getNamedQuery("Investidor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			investidor = (Investidor) consulta.uniqueResult();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return investidor;
	}

	/**************************************************************/

	public void excluir(Investidor investidor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(investidor);
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

	/**************************************************************/

	public void editar(Investidor investidor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(investidor);
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

	/**************************************************************/

}
