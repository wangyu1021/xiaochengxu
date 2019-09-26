package xcx.service;

import java.util.List;

import xcx.pojo.Cart;
import xcx.vo.CartProduct;

public interface CartService {

	void addProductToCart(Cart cart);

	List<CartProduct>  findCartByOpenid(String openid);

	void deleteCart(Integer id);

}
