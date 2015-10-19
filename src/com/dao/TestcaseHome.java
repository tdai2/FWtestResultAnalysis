package com.dao;

// Generated Oct 19, 2015 2:31:40 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import com.model.Testcase;

/**
 * Home object for domain model class Testcase.
 * @see .Testcase
 * @author Hibernate Tools
 */
public class TestcaseHome {

	private static final Log log = LogFactory.getLog(TestcaseHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Testcase transientInstance) {
		log.debug("persisting Testcase instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Testcase instance) {
		log.debug("attaching dirty Testcase instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Testcase instance) {
		log.debug("attaching clean Testcase instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Testcase persistentInstance) {
		log.debug("deleting Testcase instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Testcase merge(Testcase detachedInstance) {
		log.debug("merging Testcase instance");
		try {
			Testcase result = (Testcase) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Testcase findById(java.lang.Integer id) {
		log.debug("getting Testcase instance with id: " + id);
		try {
			Testcase instance = (Testcase) sessionFactory.getCurrentSession().get("Testcase", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Testcase> findByExample(Testcase instance) {
		log.debug("finding Testcase instance by example");
		try {
			List<Testcase> results = (List<Testcase>) sessionFactory.getCurrentSession().createCriteria("Testcase")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
