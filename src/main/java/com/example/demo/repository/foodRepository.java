package com.example.demo.repository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.table_food;

public interface foodRepository extends JpaRepository<table_food,Long>{
	List<table_food> findByCategory(String cat);
	List<table_food>findByprice(long price);
	List<table_food> findByprice(Object price);

}
