package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.model.Player;
@Repository
public class PlayerDao {
	@Autowired
	private SessionFactory sessionFactory;
	// List<Player>players=new LinkedList<Player>();
//	public PlayerDao() {
//		players.add(new Player(1, "MI", "Mumbai", "Polard"));
//		players.add(new Player(2, "CSK", "Chennai", "Dhoni"));
//	}

	public String addPlayer(Player player) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(player);
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

	public List<Player> getAllPlayers() {
		Session session = null;
		List<Player> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Player.class);
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

	public Player getPlayerById(int id) {
		Session session = null;
		Player player = null;
		try {
			session = sessionFactory.openSession();
			player = session.get(Player.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}return player;
	}

	public int deletePlayer(int id) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Player player = session.get(Player.class, id);
			session.delete(player);
			session.beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (session != null) {
				session.close();
			}
		}return 1;
	}

	public int updatePlayer(int id, Player player) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction() ;
			int status = deletePlayer(id);
			
			if (status == 1) {
				session.saveOrUpdate(player);
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
