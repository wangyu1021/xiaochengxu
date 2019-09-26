package xcx.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import xcx.pojo.Cart;
import xcx.pojo.JsonResult;
import xcx.service.CartService;
import xcx.vo.CartProduct;
@CrossOrigin
@Controller
@RequestMapping("/cart")
@Api(value = "/cart" ,tags="购物车")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/addProductToCart.do")
	@ResponseBody
	@ApiOperation(value = "添加商品到购物车", notes = "添加商品到购物车", httpMethod = "GET", response = JsonResult.class)
	public JsonResult addProduct(Integer productId,String openid,int num) {
		JsonResult json=new JsonResult();
		try {
			Cart cart=new Cart();
			cart.setProductId(productId);
			cart.setNum(num);
			cart.setOpenid(openid);
			cartService.addProductToCart(cart);
			json.setState(1);
			json.setMessage("添加购物车成功");
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("购物车出问题了，请重试");
		}
		return json;
	}
	@RequestMapping("/findCart.do")
	@ResponseBody
	@ApiOperation(value = "查询购物车", notes = "查询购物车", httpMethod = "GET", response = JsonResult.class)
	public  JsonResult findCart(String openid) {
		JsonResult json=new JsonResult();
		try {
			List<CartProduct> list=cartService.findCartByOpenid(openid);
			json.setState(1);
			json.setData(list);
		} catch (Exception e) {
			json.setState(0);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping("/deleteCart.do")
	@ResponseBody
	@ApiOperation(value = "删除购物车", notes = "删除购物车", httpMethod = "GET", response = JsonResult.class)
	public JsonResult deleteCart(Integer id) {
		JsonResult json=new JsonResult();
		try {
			cartService.deleteCart(id);
			json.setState(1);
			json.setMessage("删除成功");
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("删除失败");
		}
		return json;
	}
}
