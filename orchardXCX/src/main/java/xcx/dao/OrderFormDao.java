package xcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xcx.pojo.OrderForm;

public interface OrderFormDao {
	void addOrderForm(OrderForm orderForm);

	List<OrderForm> selectOrder(String openid);

	void deleteOrder(Integer id);

	void updateOrderStatus(@Param("id")Integer id,@Param("status") Integer status);

	OrderForm findOrderByNumber(Long number);

}
