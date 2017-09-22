package com.favourable.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

import com.favourable.domain.Item;
import com.favourable.service.ShowItemOfMarketService;
import com.favourable.servlet.ShowItemOfMarketServelet;

public class CatagoryTest {

	@Test
	public void testCatagory() {
		ShowItemOfMarketService service = new ShowItemOfMarketService(1);
		try {
			ArrayList<Item> lists = service.showItemofCatagory("Ë®¹û");

			System.out.println(lists.get(0).getItemName());
			Assert.assertNotNull(lists);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
