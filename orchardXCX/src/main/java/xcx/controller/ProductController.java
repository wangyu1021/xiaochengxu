package xcx.controller;

import io.swagger.annotations.ApiOperation;
import xcx.pojo.JsonResult;
import xcx.pojo.Product;
import xcx.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin
@Controller
@RequestMapping("product")
@Api(value = "/product", tags = "商品接口")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/findProduct.do")
	@ResponseBody
	@ApiOperation(value = "商品获取", notes = "商品获取", httpMethod = "GET", response = JsonResult.class)
	public JsonResult findProduct() {
		JsonResult json=new JsonResult();
		try {
			List<Product> list=productService.findProduct();
			json.setState(1);
			json.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
			json.setState(0);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping("/findProductByName.do")
	@ResponseBody
	@ApiOperation(value = "根据商品名称获取", notes = "根据商品名称获取", httpMethod = "GET", response = JsonResult.class)
	public JsonResult findProductByName(String name) {
		JsonResult json=new JsonResult();
		try {
			List<Product> list=productService.findProductByName(name);
			json.setState(1);
			json.setData(list);
		} catch (Exception e) {
			e.printStackTrace();
			json.setState(0);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	@RequestMapping("/findProductByClassifyId.do")
	@ResponseBody
	@ApiOperation(value = "分类获取商品", notes = "分类获取商品", httpMethod = "GET", response = JsonResult.class)
	public JsonResult findProductByClassifyId(Integer classifyId) {
		JsonResult json = new JsonResult();
		try {
			List<Product> list=productService.findProductByClassifyId(classifyId);
			json.setState(1);
			json.setData(list);
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("出错了");
		}
		return json;
	}
	
}
