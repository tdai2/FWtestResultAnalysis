package com.dao;

import static org.junit.Assert.*;
import com.model.*;
import org.junit.Before;
import org.junit.Test;

public class TestProductDao {

	@Before
	public void setUp() throws Exception {
	}
/*
	@Test
	public void testDeleteProduct() {
		fail("Not yet implemented");
	}
*/
	@Test
	public void testAddProduct() {
		ProductDao productDao=new ProductDao();
		try{
		productDao.addProduct("Grantly", "CatwoodPass");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
/*
	@Test
	public void testEditProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProductList() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProduct() {
		fail("Not yet implemented");
	}
*/
}
