package com.eshop.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.eshop.domain.ItemCategory;
import com.eshop.domain.Items;

public class ItemDataService {

	List<Items> electronicItems = new ArrayList<Items>();
	Map<Items,Integer> currentOrder = new HashMap<Items,Integer>();
	
	public ItemDataService() {
		electronicItems.add(new Items(1, "Samsung Galaxy Tab A", "SmartPhone with 8 GB RAM, Front(8 MP)/ Rear(13 MP), 64 GB internal storage tab, Android 8", ItemCategory.MOBILE, 21500));
		electronicItems.add(new Items(2, "Mivi", "wired speakers", ItemCategory.SPEAKERS, 3500));	
                electronicItems.add(new Items(3, "iBall", "Waterproof wireless speaker with portable bluetooth", ItemCategory.SPEAKERS, 999));	
                electronicItems.add(new Items(4, "Redmi Note 9 Pro", "8 GB RAM, Front(8 MP)/ Rear(13 MP), 64 GB internal storage, Android 9.0", ItemCategory.MOBILE, 22540));
		electronicItems.add(new Items(5, "Samsung S8", "16 GB RAM, Front(8 MP)/ Rear(13 MP), 64 GB internal storage, Android 7.0, Face configuration", ItemCategory.MOBILE, 16880));
		electronicItems.add(new Items(6, "Samsung J7", "8 GB RAM, Front(8 MP)/ Rear(13 MP), 32 GB internal storage, Android 8.0, Finger print Lock", ItemCategory.MOBILE,21900));
		electronicItems.add(new Items(7, "Dell", "15.6 inch, 4GB RAM, 500 GB HHD  256 SSD. WIndows 10, i3 8th Generation", ItemCategory.LAPTOP, 35550));	
                electronicItems.add(new Items(8, "MacBook Pro", "13 inch, 8GB RAM, 1 TB HHD, i5 10th Genration ", ItemCategory.LAPTOP, 119700));	
                electronicItems.add(new Items(9, "Samsung A50", "8 GB RAM, Front(8 MP)/ Rear(13 MP), 64 GB internal storage, Android 9.0", ItemCategory.MOBILE, 30120));
		electronicItems.add(new Items(10, "Vivo S1 Pro", "16 GB RAM, Front(8 MP)/ Rear(13 MP), 32 GB internal storage, Android 8.0", ItemCategory.MOBILE, 20800));
		electronicItems.add(new Items(11, "Vivo V9", "4 GB RAM, Front(18 MP)/ Rear(32 MP), 64 GB internal storage, Android 9.0, ", ItemCategory.MOBILE, 25000));
		electronicItems.add(new Items(12, "Vivo V11", "8 GB RAM, Front(16 MP)/ Rear(32 MP), 32 GB internal storage, Android 9.0", ItemCategory.MOBILE, 23590));
		electronicItems.add(new Items(13, "BOAT", "protable bluetooth speakers / black", ItemCategory.SPEAKERS, 5555));
                electronicItems.add(new Items(14, "JBL", "portable wireless with mic and rich bass", ItemCategory.SPEAKERS, 2000));	
                electronicItems.add(new Items(15, "Redmi Note 8 Pro", "8 GB RAM, Front(13 MP)/ Rear(13 MP), 32 GB internal storage, Android 7", ItemCategory.MOBILE, 19870));
		electronicItems.add(new Items(16, "Redmi Note 4", "4 GB RAM, Front(8 MP)/ Rear(13 MP), 32 GB internal storage, Android 8 ", ItemCategory.MOBILE, 15500));
                electronicItems.add(new Items(17, "Sony", "Wireless and waterproof speaker with extra bass", ItemCategory.SPEAKERS, 2999));	
                electronicItems.add(new Items(18, "HP", "15.6 inch, 4GB RAM, 1 TB HHD + 256 SSD, Windows 10, i3 8th Generation", ItemCategory.LAPTOP, 45700));	
                electronicItems.add(new Items(19, "Lenovo", "15 inch, 4GB RAM, 1 TB HHD. Windows 10, i5 8th generation", ItemCategory.LAPTOP, 36000));	
                electronicItems.add(new Items(20, "BOSS", "wireless speaker with HD sound", ItemCategory.SPEAKERS, 2999));	
                electronicItems.add(new Items(21, "Mivi", "Bluetooth wireless speaker, with inbuilt FM radio", ItemCategory.SPEAKERS, 1299));	
                electronicItems.add(new Items(22, "Asus", "15.6 inch, 4GB RAM, 1 TB HHD, Windows 10, i5 10th Generation ", ItemCategory.LAPTOP, 56700));	
   
	}
	
	public List<Items>  getFullItems() {
		return electronicItems;
	}
	
	public List<Items> find(String searchString) {
		List<Items> results = new ArrayList<Items>();
		for (Items item : electronicItems) {
			if (item.getName().toLowerCase().contains(searchString.toLowerCase()) || item.getDescription().toLowerCase().contains(searchString.toLowerCase())) {
				results.add(item);
			}
		}
		
		return results;
	}
	
	public Items getItem(int id) {
		return electronicItems.get(id);
	}
	
	public void addToOrder(Items item, int quantity) {
		int currentQuantity = 0;
		if (currentOrder.get(item) != null) currentQuantity = currentOrder.get(item);
		currentOrder.put(item, currentQuantity + quantity);
	}
	
	public Double getOrderTotal() {
		double d = 0d;
		for (Items item : currentOrder.keySet()) {
			d += currentOrder.get(item) * item.getPrice();
		}
		return d;
	}
}
