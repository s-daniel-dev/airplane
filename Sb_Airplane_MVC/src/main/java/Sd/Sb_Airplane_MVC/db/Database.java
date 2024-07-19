package Sd.Sb_Airplane_MVC.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.SelectionQuery;
import org.springframework.stereotype.Repository;

import Sd.Sb_Airplane_MVC.model.Flight;

@Repository
public class Database {
	
	private SessionFactory sessionFactory;
	
	
	public Database() {

		Configuration cfg = new Configuration();
		cfg.configure();
		this.sessionFactory = cfg.buildSessionFactory();
		
	}



	public List<Flight> getFlights() {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		SelectionQuery<Flight> query = session.createSelectionQuery
						(
							"SELECT f FROM Flight f", Flight.class
						);
		
		List<Flight> list = query.getResultList();
		
		tx.commit();
		session.close();
		
		return list;
	}


}
