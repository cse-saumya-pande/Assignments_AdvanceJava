package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	//add book 
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	//delete book
	public void deleteBook(int id) {
		if(!bookRepository.existsById(id)) {
			throw new RuntimeException("Id not found by : " + id);
		}
		bookRepository.deleteById(id);
	}
	//update
	public Book updateBook(Book updatedBook, int id) {

	    Book existingBook = bookRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Id not found: " + id));

	    existingBook.setTitle(updatedBook.getTitle());
	    existingBook.setAuthor(updatedBook.getAuthor());
	    existingBook.setGenre(updatedBook.getGenre());
	    existingBook.setPrice(updatedBook.getPrice());
	    existingBook.setPublishedDate(updatedBook.getPublishedDate());

	    return bookRepository.save(existingBook);
	}
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	//find by author 
	public List<Book> getByAuthor(String author){
		return bookRepository.findByAuthor(author);
	}
	
	//find by genre
	public List<Book> getByGenre(String Genre){
		return bookRepository.findByGenre(Genre);
	}
	
	public List<Book> getByPriceLessThan(double price){
		return bookRepository.findByPriceLessThan(price);
	}
	
	public List<Book> getByPriceGreaterThan(double price){
		return bookRepository.findByPriceGreaterThan(price);
	}
	
	public List<Book> getByPublishedDateAfter(LocalDate date){
		return bookRepository.findByPublishedDateAfter(date);
	}
	
	public List<Book> getByPublishedDateBefore(LocalDate date){
		return bookRepository.findByPublishedDateBefore(date);
	}
	
	public List<Book> searchByTitleContaining(String keyword) {
        return bookRepository.findByTitleContaining(keyword);
    }

    public List<Book> searchByTitleStartingWith(String prefix) {
        return bookRepository.findByTitleStartingWith(prefix);
    }
    public List<Book> searchByTitleEndingWith(String suffix) {
        return bookRepository.findByTitleEndingWith(suffix);
    }

    public List<Book> getByGenreAndAuthor(String genre, String author) {
        return bookRepository.findByGenreAndAuthor(genre, author);
    }

    public List<Book> getByGenreOrAuthor(String genre, String author) {
        return bookRepository.findByGenreOrAuthor(genre, author);
    }

    public List<Book> getByPriceBetween(Double minPrice, Double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Book> getByGenreAndPriceLessThan(String genre, Double price) {
        return bookRepository.findByGenreAndPriceLessThan(genre, price);
    }

    public Page<Book> getAllOrderByPublishedDateDesc(
            int page,
            int size,
            String sortBy,
            String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return bookRepository.findAll(pageable);
    }

    public Page<Book> getAllOrderByPriceAsc(
            int page,
            int size,
            String sortBy,
            String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return bookRepository.findAll(pageable);
    }
	
	//sort by without pagination
	public List<Book> getSortedBy(String field, String direction){
		Sort sort = direction.equalsIgnoreCase("Asc") ?
			Sort.by(field).ascending() : 
				Sort.by(field).descending();
		
		return bookRepository.findAll(sort);
	}
	
	//
	
	
}