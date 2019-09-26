package xcx.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xcx.dao.CartDao;
import xcx.dao.ProductDao;
import xcx.pojo.Cart;
import xcx.pojo.Product;
import xcx.service.CartService;
import xcx.vo.CartProduct;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao productDao;

	public void addProductToCart(Cart cart) {
		Cart ct=cartDao.selectProduct(cart.getOpenid(),cart.getProductId());
		if(ct!=null) {
			Integer num=ct.getNum()+cart.getNum();
			cartDao.updateNum(num,cart.getOpenid(),cart.getProductId());
		}else {
			cartDao.insertProduct(cart);
		}
	}

	public List<CartProduct> findCartByOpenid(String openid) {
		List<CartProduct> list=new ArrayList<CartProduct>();
		List<Cart> carts=cartDao.selectCartByOpenid(openid);
		if(carts.size()==0) {
			throw new IllegalArgumentException("购物车里没有东西");
		}
		for(Cart cart:carts) {
			Product product=productDao.selectProductById(cart.getProductId());
			CartProduct cp=new CartProduct();
			cp.setName(product.getName());
			cp.setImage(product.getImage());
			cp.setPrice(product.getPrice());
			cp.setNum(cart.getNum());
			cp.setId(cart.getId());
			list.add(cp);
		}
		return list;
	}

	public void deleteCart(Integer id) {
		cartDao.deleteCart(id);
	}

}
