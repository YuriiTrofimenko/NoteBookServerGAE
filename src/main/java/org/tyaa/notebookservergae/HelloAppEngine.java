package org.tyaa.notebookservergae;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tyaa.notebookservergae.dao.DAO;
import org.tyaa.notebookservergae.entity.Order1;
import org.tyaa.notebookservergae.entity.Orders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
      
    //response.setContentType("text/plain");
	response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    //PrintWriter out = response.getWriter();
    //Преобразователь из объектов Java в строки JSON
    Gson gson =// new Gson();
    		new GsonBuilder()
            .setDateFormat("yyyy-MM-dd").create();
    
    //Открываем выходной поток - с сервера к клиенту (браузеру/мобильному приложению)
    try (PrintWriter out = response.getWriter()) {
    	
    	//Проверяем, присутствует ли в коллекции параметров запроса
    	//параметр с именем action
    	if (request.getParameterMap().keySet().contains("action")) {
            
            switch(request.getParameter("action")) {
                
            	case "get_order" : {
                
                    String idString = request.getParameter("id");
                    Order1 order = DAO.getOrder(idString);
                    String orderJson = gson.toJson(order);
                    out.print(orderJson);
                    break;
                }
                case "get_orders" : {
                
                	List<Order1> orders = DAO.getAllOrders();
                	String orderJson = gson.toJson(orders);
                    out.print(orderJson);
                    break;
                }
                /*case "create_order" : {
                
                    try {
                        String customerName = request.getParameter("customer_name");
                        String description = request.getParameter("description");
                        State state = stateFacade.findByName("created");
                        
                        if (state == null) {
                            
                            out.print(gson.toJson("State not exists"));
                            break;
                        }
                        
                        Order1 order1 = new Order1();
                        order1.setCustomerName(customerName);
                        order1.setDescription(description);
                        order1.setCreatedAt(new Date());
                        order1.setStateId(state);
                        order1Facade.create(order1);
                        out.print(gson.toJson("ok"));
                    } catch (Exception e) {
                        out.print(gson.toJson("error"));
                    }
                }*/
            }
    }
    
    Order1 o = new Order1();
    o.setCustomer("cmr1");
    o.setText("task1");
    o.setStateId(1L);
    o.setDate(new Date());
    
    Order1 o2 = new Order1();
    o2.setCustomer("cmr2");
    o2.setText("task2");
    o2.setStateId(1L);
    o2.setDate(new Date());
    
    //String orderJson = g.toJson(o);
    
    List<Order1> orders = new ArrayList();
    orders.add(o);
    orders.add(o2);
    
    Orders ordersModel = new Orders(orders);
    
    String orderJson = g.toJson(ordersModel);
    
    out.print(orderJson);
    
    //out.print("Hello App Engine!\r\n");

  }
}