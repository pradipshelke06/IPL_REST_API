package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.model.Match;
@Repository
public class MatchDao {
	@Autowired
	private SessionFactory sessionFactory;
	// List<Match>matchs=new LinkedList<Match>();
//	public MatchDao() {
//		matchs.add(new Match(1, "MI", "Mumbai", "Polard"));
//		matchs.add(new Match(2, "CSK", "Chennai", "Dhoni"));
//	}

	public String addMatch(Match match) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(match);
			session.beginTransaction().commit();
			return "Added Successfully...";
		} catch (Exception e) {
			e.printStackTrace();
			return "Something Went Wrong";
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	public List<Match> getAllMatchs() {
		Session session = null;
		List<Match> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Match.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;

	}

	public Match getMatchById(int id) {
		Session session = null;
		Match match = null;
		try {
			session = sessionFactory.openSession();
			match = session.get(Match.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}return match;
	}

	public int deleteMatch(int id) {
		Session session = null;
		 
		try {
			session = sessionFactory.openSession();
			Match match = session.get(Match.class, id);
			session.delete(match);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}return 1;
	}

	public int updateMatch(int id, Match match) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction() ;
			int status = deleteMatch(id);
			
			if (status == 1) {
				session.saveOrUpdate(match);
				transaction.commit();
				return 1;
			} else {
				transaction.rollback();
				return 0;
			}
		} catch (Exception e) {
			 if (transaction != null) {
		            transaction.rollback();
		        }
			e.printStackTrace();
			return -1;
		}finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
