package net.roseindia.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import net.roseindia.model.Employees;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
    @Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
    
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addEmployee(Employees p) {
		Session session = sessionFactory.openSession();
		
		session.save(p);
		System.out.println("Employee saved successfully, Employee Details="+p);
		
		session.close();
	}

	public void updateEmployee(Employees p) {
		Session session = sessionFactory.openSession();
		session.update(p);
		session.flush();
		System.out.println("Employee updated successfully, Employee Details="+p);
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Employees> listEmployee() {
		System.out.println("inside list employee");
		Session session = sessionFactory.openSession();
		List<Employees> personsList = session.createQuery("from Employees").list();
		for(Employees p : personsList){
			System.out.println("Employee:"+p.getFirstName() + p.getLastName() + " id= " + p.getId());
		}
		session.close();
		
		return personsList;
	}

	public Employees getEmployeeById(int id) {
		Session session = sessionFactory.openSession();		
		Employees p = (Employees) session.load(Employees.class, new Long(id));
		System.out.println("Employee loaded successfully, Employee details="+p);
		session.close();
		return p;
	}

	public void removeEmployee(int id) {
		Session session = sessionFactory.openSession();
		Employees p = (Employees) session.load(Employees.class, new Long(id));
		if(null != p){
			session.delete(p);
			session.flush();
		}
		System.out.println("Employee deleted successfully, employee details="+p);
		session.close();
	}
}
