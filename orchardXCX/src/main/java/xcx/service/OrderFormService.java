package xcx.service;

import java.util.List;

import xcx.pojo.OrderForm;

public interface OrderFormService {

	void addOrderForm(OrderForm orderForm);

	List<OrderForm> findOrder(String openid);

	void deleteOrder(Integer id);

	void updateOrderStatus(Integer id, Integer status);

	void payOrder(Long number, String openid);

}
