package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Sp7RestSecurityQ16Application;
import com.example.demo.model.Book;

import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	//add
	public Book addBook(Book book){
		return bookRepository.save(book);
	}
	//view all
	public List<Book> getAll(){
		return bookRepository.findAll();
	}
	//viewById
	public Book getById(int id) {
		return bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found by ID : " + id));
	}
	//delete
	public void deleteById(int id) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found by ID : " + id));
		bookRepository.deleteById(id);
	}
}
