package org.tyaa.notebookservergae.entity;

import java.util.ArrayList;
import java.util.List;

public class Orders {

	public List<Order1> orders;
	
	public Orders(List<Order1> _orders)
	{
		orders = _orders;
	}
	
	public void addOrders(List<Order1> _orders) {
		
		if(orders == null) {
			
			orders = new ArrayList();
		}
		
		orders.addAll(_orders);
	}
}
