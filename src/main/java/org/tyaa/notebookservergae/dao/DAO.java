package org.tyaa.notebookservergae.dao;

import org.tyaa.notebookservergae.entity.Order1;
import org.tyaa.notebookservergae.entity.State;

import com.googlecode.objectify.*;
import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

public class DAO {
	
	private static Objectify mOFY;

	static {
		
		ObjectifyService.register(State.class);
		ObjectifyService.register(Order1.class);
		
		mOFY = ofy();
	}
	
	//Получение одного заказа по его id
	public static Order1 getOrder(String _id) {
		
		return mOFY.load().type(Order1.class).filter("id", _id).first().now();
	}
	
	//Добавление нового заказа в БД
	public static void saveOrder(Order1 _order) {
		
		mOFY.save().entity(_order).now();
	}
	
	public static List<Order1> getAllOrders() {
		
		//Query<OrderData> query = mOFY.query(OrderData.class);
		//return new OrdersData((List<OrderData>) query.list());
		return mOFY.load().type(Order1.class).list();
	}
}
