package com.example.demo.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "table_admin")
public class table_admin {

	
	

	  

	
	
	
	
		@Id
		@GeneratedValue
		private long id;
		private String fullname;
		private String username;
		private String password;
		private String featured;
		private String active;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getFullname() {
			return fullname;
		}
		public void setFullname(String fullname) {
			this.fullname = fullname;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getFeatured() {
			return featured;
		}
		public void setFeatured(String featured) {
			this.featured = featured;
		}
		public String getActive() {
			return active;
		}
		public void setActive(String active) {
			this.active = active;
		}
		
}
