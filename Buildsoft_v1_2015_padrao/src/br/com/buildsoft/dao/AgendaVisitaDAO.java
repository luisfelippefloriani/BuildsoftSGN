package br.com.buildsoft.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.buildsoft.domain.AgendaVisita;
import br.com.buildsoft.util.HibernateUtil;

public class AgendaVisitaDAO {

	/*******************************************************************/

	public Long salvar(AgendaVisita agendaVisita) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		Long codigo = null;

		try {
			transacao = sessao.beginTransaction();
			codigo = (Long) sessao.save(agendaVisita);
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

	/*******************************************************************/

	@SuppressWarnings("unchecked")
	public List<AgendaVisita> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<AgendaVisita> agendaVisitas = null;

		try {
			Query consulta = sessao.getNamedQuery("AgendaVisita.listar");
			agendaVisitas = consulta.list();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return agendaVisitas;
	}

	/*******************************************************************/

	public AgendaVisita buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		AgendaVisita agendaVisita = null;

		try {
			Query consulta = sessao
					.getNamedQuery("AgendaVisita.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			agendaVisita = (AgendaVisita) consulta.uniqueResult();

		} catch (RuntimeException ex) {

			throw ex;
		} finally {
			sessao.close();

		}
		return agendaVisita;
	}

	/*******************************************************************/

	public void excluir(AgendaVisita agendaVisita) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(agendaVisita);
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

	/*******************************************************************/

	public void editar(AgendaVisita agendaVisita) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(agendaVisita);
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

	/*******************************************************************/

}
