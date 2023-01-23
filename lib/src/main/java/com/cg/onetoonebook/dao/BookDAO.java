package com.cg.onetoonebook.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cg.onetoonebook.config.Onetooneconfig;
import com.cg.onetoonebook.entity.Book;

public class BookDAO {
	
	public void insertBook(Book instr) {
		
		Transaction hibTrans = null;
		Session dbSession = null;
		try {
			dbSession = Onetooneconfig.getSessionFactory().openSession();
			//start the transaction
			hibTrans = dbSession.beginTransaction();
			//save the instructor object
			dbSession.save(instr);
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
	public void getBooks() {
		Transaction hibTrans = null;
		Session dbSession = null;
		try {
			dbSession = Onetooneconfig.getSessionFactory().openSession();
			//start the transaction
			hibTrans = dbSession.beginTransaction();
			//get all the instructors object
			List<Book> booklist = dbSession.createQuery("from Book").list();
			System.out.println("Book title \t Book description");
			booklist.forEach(instr ->System.out.println(instr.getTitle() + "\t" + instr.getDescription()));
		}catch (Exception e) {
			if(hibTrans !=null) {
				hibTrans.rollback();
			}
			e.printStackTrace();
		}
	}

}

