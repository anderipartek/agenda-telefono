package com.ipartek.agenda.database;

import java.util.ArrayList;

import org.hibernate.Session;

import com.ipartek.agenda.bean.Amigo;
import com.ipartek.agenda.database.interfaces.IDAOAmigo;
import com.ipartek.agenda.hibernate.HibernateUtil;

public class HibernateAmigo implements IDAOAmigo {

	@Override
	public long add(Amigo amigo) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(amigo);
		return amigo.getId();
	}

	@Override
	public ArrayList<Amigo> getAll() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		ArrayList<Amigo> result = (ArrayList<Amigo>) session.createQuery("from amigos").list();
		session.getTransaction().commit();
		return result;
	}

	@Override
	public ArrayList<Amigo> getByName(String value) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		ArrayList<Amigo> result = (ArrayList<Amigo>) session.createQuery("from amigos where name like '" + value + "'").list();
		session.getTransaction().commit();
		return result;
	}

	@Override
	public Amigo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Amigo amigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
