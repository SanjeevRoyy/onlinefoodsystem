package com.example.demo.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.table_admin;

public interface adminRepository extends JpaRepository<table_admin,Long> {
	table_admin findByUsernameAndPassword(String un, String psw);
}
