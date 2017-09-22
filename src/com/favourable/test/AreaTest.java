package com.favourable.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.favourable.domain.Area;
import com.favourable.domain.Item;
import com.favourable.service.ShowAreaService;
import com.favourable.service.ShowItemService;

public class AreaTest {

	@Test
	public void testArea() {
		ShowAreaService showAreaService = new ShowAreaService();
		List<Area> areaList = showAreaService.showAllAreas();
		Assert.assertNotNull(areaList);

	}

	@Test
	public void testSearchService() {
		ArrayList<Item> lists = new ArrayList<Item>();
		ShowItemService service = new ShowItemService();
		lists = (ArrayList<Item>) service.showItemByItemName("Î÷¹Ï");
		System.out.print(lists.get(0).getItemName());
	}
}
