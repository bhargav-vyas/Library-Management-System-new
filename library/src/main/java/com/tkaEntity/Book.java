package com.tkaEntity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private  Long  Id;
	private String  title ;
	private String author;
	private String idbn;
	 private  int publishedYear;
	 private String category;
	 private  int availableCopies; 
	

}
