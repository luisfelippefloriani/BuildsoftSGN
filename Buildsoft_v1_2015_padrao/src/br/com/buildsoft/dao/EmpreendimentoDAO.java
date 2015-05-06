package br.com.buildsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.buildsoft.domain.Empreendimento;
import br.com.buildsoft.util.HibernateUtil;

public class EmpreendimentoDAO {

	/**********************************************************************/

	public void salvar(Empreendimento empreendimento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(empreendimento);
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
	public List<Empreendimento> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Empreendimento> empreendimentos = null;

		try {
			Query consulta = sessao.getNamedQuery("Empreendimento.listar");
			empreendimentos = consulta.list();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return empreendimentos;
	}

	/**************************************************************/

	public Empreendimento buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Empreendimento empreendimento = null;

		try {
			Query consulta = sessao
					.getNamedQuery("Empreendimento.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			empreendimento = (Empreendimento) consulta.uniqueResult();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return empreendimento;
	}

	/**************************************************************/

	public void excluir(Empreendimento empreendimento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(empreendimento);
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

	public void editar(Empreendimento empreendimento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(empreendimento);
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
