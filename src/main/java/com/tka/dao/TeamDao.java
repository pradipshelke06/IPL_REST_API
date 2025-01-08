package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.model.Team;

@Repository
public class TeamDao {
	@Autowired
	private SessionFactory sessionFactory;
	// List<Team>teams=new LinkedList<Team>();
//	public TeamDao() {
//		teams.add(new Team(1, "MI", "Mumbai", "Polard"));
//		teams.add(new Team(2, "CSK", "Chennai", "Dhoni"));
//	}

	public String addTeam(Team team) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(team);
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

	public List<Team> getAllTeams() {
		Session session = null;
		List<Team> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Team.class);
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

	public Team getTeamById(int id) {
		Session session = null;
		Team team = null;
		try {
			session = sessionFactory.openSession();
			team = session.get(Team.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}return team;
	}

	public int deleteTeam(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Team team = session.get(Team.class, id);
			session.delete(team);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}return 1;
	}

	public int updateTeam(int id, Team team) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction() ;
			int status = deleteTeam(id);
			
			if (status == 1) {
				session.saveOrUpdate(team);
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
