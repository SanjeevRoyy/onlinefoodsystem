package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.table_contact;

public interface contactRepository extends JpaRepository<table_contact,Long>{

	
}
