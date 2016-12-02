package com.crivero.microservice.product.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crivero.microservice.product.Product;
import com.crivero.microservice.product.dao.ProductDao;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

	@Autowired
	@Qualifier("productSessionFactory")
	private SessionFactory sessionFactory;

	public Product findById(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Product employee = null;
		try {
			tx = session.beginTransaction();
			employee = session.load(Product.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employee;
	}

	public void delete(String id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(findById(id));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void save(String id, String name, String company) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new Product(id, name, company));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		List<Product> products = null;
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			products = (List<Product>) session.createQuery("from Product").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return products;
	}
}