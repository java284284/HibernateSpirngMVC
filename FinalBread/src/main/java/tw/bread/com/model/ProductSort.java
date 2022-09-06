package tw.bread.com.model;

import java.util.Comparator;

public class ProductSort implements Comparator<Products>{

		public int compare(Products a, Products b) 
		{ 
			return a.getPrice() - b.getPrice(); 
		}
}
