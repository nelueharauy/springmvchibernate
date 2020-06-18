package net.roseindia.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.roseindia.model.Users;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
     
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

       public String checkLogin(String userName, String userPassword){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			String userType;
			//Query using Hibernate Query Language
			String SQL_QUERY =" from Users as o where o.userName=? and o.userPassword=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			List list = query.list();

			//TODO: add checker must return only 1 result
			if ((list != null) && (list.size() > 0)) {
				Users user = (Users) list.get(0);
				System.out.println("user type:" + user.getUserType());
				userType = user.getUserType();
			} else {
				userType = "NOTFOUND";
			}

			session.close();
			return userType;              
       }
}