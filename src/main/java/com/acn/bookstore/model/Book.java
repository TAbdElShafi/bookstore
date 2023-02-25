package com.acn.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Book {
	@Id  
	@Column  
	private int bookId;
	@Column  
	private String bookName;
	@Column  
	private String author;  
	@Column  
	private int price;  
}
