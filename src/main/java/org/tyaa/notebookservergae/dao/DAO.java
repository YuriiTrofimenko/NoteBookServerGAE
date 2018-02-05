package org.tyaa.notebookservergae.dao;

import org.tyaa.notebookservergae.entity.Order1;
import org.tyaa.notebookservergae.entity.State;

import com.googlecode.objectify.*;
import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO {
	
	//Получение одного заказа по его id
	public static void getOrder(String _id, Order1 _emptyOrder) {
		
		Order1 order =
				ofy().load().type(Order1.class).id(Long.valueOf(_id)).now();
		
		_emptyOrder.setId(order.getId());
		_emptyOrder.setCustomer(order.getCustomer());
		_emptyOrder.setText(order.getText());
		_emptyOrder.setDate(order.getDate());
		_emptyOrder.setStateId(order.getStateId());
	}
	
	//Получение всех заказов в виде списка
	public static void getAllOrders(List<Order1> _emptyOrdersList) throws Exception {
		
		_emptyOrdersList.addAll(ofy().load().type(Order1.class).list());
	}
	
	public static void createOrder(String _customerName, String _taskText) {
		
		State state =
        		ofy().load()
        		.type(State.class)
        		.filter("name", "created")
        		.first()
        		.now();
        
        Order1 order1 = new Order1();
        order1.setCustomer(_customerName);
        order1.setText(_taskText);
        order1.setDate(new Date());
        order1.setStateId(state.getId());
        ofy().save().entity(order1).now();
	}
	
	//Обновление данных заказа по его _id
	public static void updateOrder(String _id, String _customerName, String _taskText) {
		
		Order1 order = new Order1();
		getOrder(_id, order);
		order.setCustomer(_customerName);
		order.setText(_taskText);
		order.setDate(new Date());
		ofy().save().entity(order).now();
	}
	
	//Удаление одногозаказа по его _id
	public static void deleteOrder(String _id) {
		
		ofy().delete()
				.type(Order1.class)
				.id(Long.valueOf(_id))
				.now();
	}
}
