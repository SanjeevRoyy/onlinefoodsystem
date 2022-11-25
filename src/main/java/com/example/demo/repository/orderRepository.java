package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.table_order;

public interface orderRepository extends JpaRepository<table_order,Long>{

}
