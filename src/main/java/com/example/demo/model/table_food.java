package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "table_food")
public class table_food {
	
	
		@Id
		@GeneratedValue
		private long id;
		private String title;
		private String description;
		private long price;
		private String select_image;
		private String category;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public long getPrice() {
			return price;
		}
		public void setPrice(long price) {
			this.price = price;
		}
		public String getSelect_image() {
			return select_image;
		}
		public void setSelect_image(String select_image) {
			this.select_image = select_image;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category= category;
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
