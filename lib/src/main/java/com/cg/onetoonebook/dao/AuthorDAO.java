package com.cg.onetoonebook.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.onetoonebook.config.Onetooneconfig;
import com.cg.onetoonebook.entity.Author;

public class AuthorDAO {
public void insertAuthor(Author instrDetails) {
		
		Transaction hibTrans = null;
		Session dbSession = null;
		try {
			dbSession = Onetooneconfig.getSessionFactory().openSession();
			//start the transaction
			hibTrans = dbSession.beginTransaction();
			//save the instructor object
			dbSession.save(instrDetails);
			//commit the transaction
			hibTrans.commit();
		}catch (Exception e) {
			if(hibTrans !=null) {
				hibTrans.rollback();
			}
			e.printStackTrace();
		}
		
	}
	
	//to read all instructors from the DB
	public void getAllAuthors() {
		Transaction hibTrans = null;
		Session dbSession = null;
		try {
			dbSession = Onetooneconfig.getSessionFactory().openSession();
			//start the transaction
			hibTrans = dbSession.beginTransaction();
			//get all the instructors object
			List<Author> authorlist = dbSession.createQuery("from Author").list();
			System.out.println("Author name \t Author Email");
			authorlist.forEach(instrDet ->System.out.println(instrDet.getName() + "\t" + instrDet.getEmail()));
		}catch (Exception e) {
			if(hibTrans !=null) {
				hibTrans.rollback();
			}
			e.printStackTrace();
		}
	}
}

