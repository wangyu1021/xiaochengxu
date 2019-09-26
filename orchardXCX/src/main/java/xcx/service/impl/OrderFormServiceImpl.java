package xcx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xcx.dao.OrderFormDao;
import xcx.dao.UserDao;
import xcx.pojo.OrderForm;
import xcx.pojo.User;
import xcx.service.OrderFormService;
import xcx.util.OrderNumber;

@Service
public class OrderFormServiceImpl implements OrderFormService {
	@Autowired
	private OrderFormDao orderFormDao;
	@Autowired
	private UserDao userDao;
	
	
	public void addOrderForm(OrderForm orderForm) {
		orderForm.setNumber(OrderNumber.getOrderNo());
		orderFormDao.addOrderForm(orderForm);
	}
	
	
	public List<OrderForm> findOrder(String openid) {
		List<OrderForm> list=orderFormDao.selectOrder(openid);
		if(list.size()==0) {
			throw new IllegalArgumentException("没有订单");
		}
		return list;
	}


	public void deleteOrder(Integer id) {
		orderFormDao.deleteOrder(id);
	}


	public void updateOrderStatus(Integer id, Integer status) {
		orderFormDao.updateOrderStatus(id,status);
	}


	public void payOrder(Long number,String openid) {
		User user = userDao.selectUserByOpenId(openid);
		Double balance=user.getBalance();
		OrderForm order=orderFormDao.findOrderByNumber(number);
		Integer num = order.getNum();
		Double price = order.getPrice();
		if(balance<num*price) {
			throw new RuntimeException("余额不足");
		}else {
			Double b=balance-num*price;
			userDao.updateBalance(b,openid);
		}
	}
	
}
