package com.cg.onetoonebook;

import java.time.LocalDate;

import com.cg.onetoonebook.dao.BookDAO;
import com.cg.onetoonebook.entity.Book;
import com.cg.onetoonebook.entity.Author;

public class Mainonetoone {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		
		//create instructor object
		Book instr = new Book();
		//set the values to the instructor object
		instr.setTitle("The Boys☕");
		instr.setDescription("❤❤❤❤SHAR❤❤❤❤");
		instr.setPublisheddate(date);
		
		
		
		
		//create instructor details object
		Author instrDet = new Author();
		//set values for instructor details object
		instrDet.setName("Sandy");
		instrDet.setEmail("rktechvlogs.com");
		//set instructor details to above instructor object
		instr.setAuthorid(instrDet);
		
		//save the instructor (which automatically saves the instructor details as cascade
		//option is enabled)
		//create an object for instructor dao
		BookDAO instrDao = new BookDAO();
		instrDao.insertBook(instr);
		
		//to display all instructor
		instrDao.getBooks();

	}

}

