package xcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xcx.pojo.Cart;

public interface CartDao {

	Cart selectProduct(@Param("openid")String openid, @Param("productId")Integer productId);

	void updateNum(@Param("num")Integer num, @Param("openid")String openid, @Param("productId")Integer productId);

	void insertProduct(Cart cart);

	List<Cart> selectCartByOpenid(String openid);

	void deleteCart(Integer id);

}
