package com.example.demo.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Controller
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	BookService bookService; 
	
	@GetMapping("/author/{author}")
	public ResponseEntity<List<Book>> getByAuthor(@PathVariable String author){
		return ResponseEntity.ok(bookService.getByAuthor(author));
	}
	
	@GetMapping("/genre/{genre}")
	public ResponseEntity<List<Book>> getByGenre(@PathVariable String genre){
		return ResponseEntity.ok(bookService.getByGenre(genre));
	}
	
	@GetMapping("/cheaper/{maxPrice}")
	public ResponseEntity<List<Book>> getCheaperThan(@PathVariable double maxPrice){
		return ResponseEntity.ok(bookService.getByPriceLessThan(maxPrice));
	}
	
	@GetMapping("/expensive/{minPrice}")
	public ResponseEntity<List<Book>> getExpensiveThan(@PathVariable double minPrice){
		return ResponseEntity.ok(bookService.getByPriceGreaterThan(minPrice));
	}
	
	@GetMapping("/new-arrivals")
	public ResponseEntity<List<Book>> getNewArrivals(){
		return ResponseEntity.ok(bookService.getByPublishedDateAfter(LocalDate.now().minus(2, ChronoUnit.WEEKS)));
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<Book>> getByKeyword(@PathVariable String keyword){
		return ResponseEntity.ok(bookService.searchByTitleContaining(keyword));
	}
	
	@GetMapping("genre-author/{genre}/{author}")
	public ResponseEntity<List<Book>> getByGenreAndAuthor(@PathVariable String genre, @PathVariable String author){
		return ResponseEntity.ok(bookService.getByGenreAndAuthor(genre, author));
	}
	
	@GetMapping("genre-or-author/{genre}/{author}")
	public ResponseEntity<List<Book>> getByGenreOrAuthor(@PathVariable String genre, @PathVariable String author){
		return ResponseEntity.ok(bookService.getByGenreOrAuthor(genre, author));
	}
	
	@GetMapping("/price-range/{minPrice}/{maxPrice}")
	public ResponseEntity<List<Book>> getByPriceRange(@PathVariable double minPrice, @PathVariable double maxPrice){
		return ResponseEntity.ok(bookService.getByPriceBetween(minPrice, maxPrice));
	}
	
	@GetMapping("/genre-discount/{genre}/{maxPrice}")
	public ResponseEntity<List<Book>> getByDisountAndGenre(@PathVariable String genre, @PathVariable double maxPrice){
		return ResponseEntity.ok(bookService.getByGenreAndPriceLessThan(genre, maxPrice));
	}
	
	@GetMapping("/latest")
	public ResponseEntity<List<Book>> getByPublishedDateSorted(){
		return ResponseEntity.ok(bookService.getSortedBy("publishedDate", "desc"));
	}
	
	@GetMapping("/by-price")
	public ResponseEntity<List<Book>> getByPriceSorted(){
		return ResponseEntity.ok(bookService.getSortedBy("price", "asc"));
	}
	
}
