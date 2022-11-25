package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "table_category")
public class table_category {
	
	
		@Id
		@GeneratedValue
		private long id;
		private String title;
		private String image_name;
		private String featured;
		private String active;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getImage_name() {
			return image_name;
		}
		public void setImage_name(String image_name) {
			this.image_name = image_name;
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
