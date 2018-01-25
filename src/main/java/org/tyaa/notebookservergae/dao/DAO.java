package org.tyaa.notebookservergae.dao;

import org.tyaa.notebookservergae.entity.Order1;
import org.tyaa.notebookservergae.entity.State;

import com.googlecode.objectify.*;
import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

public class DAO {
	
	//private static Objectify mOFY;

	/*static {
		
		ObjectifyService.register(State.class);
		ObjectifyService.register(Order1.class);
		
		//mOFY = ofy();
	}
	
	//Получение одного состояния по его названию (name)
	public static State getState(String _name) {
		
		return ofy().load().type(State.class).filter("name", _name).first().now();
	}*/
	
	//Получение одного заказа по его id
	public static void getOrder(String _id, Order1 _emptyOrder) {
		
		//_emptyOrder =
		Order1 order =
				ofy().load().type(Order1.class).id(Long.valueOf(_id)).now();
		
		_emptyOrder.setId(order.getId());
		_emptyOrder.setCustomer(order.getCustomer());
		_emptyOrder.setText(order.getText());
		_emptyOrder.setDate(order.getDate());
		_emptyOrder.setStateId(order.getStateId());
		
				//ofy().load().type(Order1.class).filter("id", _id).first().now();
		//return ofy().load().type(Order1.class).filter("id", _id).first().now();
	}
	
	/*//Добавление нового заказа в БД
	public static void saveOrder(Order1 _order) {
		
		ofy().save().entity(_order).now();
	}*/
	
	public static void getAllOrders(List<Order1> _emptyOrdersList) throws Exception {
		
		//Query<OrderData> query = mOFY.query(OrderData.class);
		//return new OrdersData((List<OrderData>) query.list());
		/*List<Order1> orders = null;
		try {
			
			orders = ofy().load().type(Order1.class).list();
		} catch (Exception ex)
		{
			//throw ex;
			orders = new ArrayList<>();
		}*/
		
		_emptyOrdersList.addAll(ofy().load().type(Order1.class).list());
		
		//return ofy().load().type(Order1.class).list();
	}
}
