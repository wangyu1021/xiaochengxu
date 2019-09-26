package xcx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import xcx.pojo.JsonResult;
import xcx.pojo.OrderForm;
import xcx.service.OrderFormService;

@CrossOrigin
@Controller
@RequestMapping("/orderForm")	
@Api(value = "/orderForm" ,tags="订单")
public class OrderFormController {
	@Autowired
	private 
	OrderFormService orderFormService;
	
	@RequestMapping("/addOrderForm.do")
	@ResponseBody
	@ApiOperation(value = "添加订单", notes = "添加订单", httpMethod = "POST", response = JsonResult.class)
	public JsonResult addOrderForm(@RequestBody OrderForm orderForm) {
		JsonResult json =new JsonResult();
		try {
			orderFormService.addOrderForm(orderForm);
			json.setState(1);
			json.setMessage("添加成功");
		} catch (Exception e) {
			json.setState(0);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping("/findOrder.do")
	@ResponseBody
	@ApiOperation(value = "查询订单", notes = "查询订单", httpMethod = "GET", response = JsonResult.class)
	public JsonResult findOrder(String openid) {
		JsonResult json=new JsonResult();
		try {
			List<OrderForm> list=orderFormService.findOrder(openid);
			json.setState(1);
			json.setData(list);
		} catch (Exception e) {
			json.setState(0);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
	
	@RequestMapping("/deleteOrder.do")
	@ResponseBody
	@ApiOperation(value = "删除订单", notes = "删除订单", httpMethod = "GET", response = JsonResult.class)
	public JsonResult deleteOrder(Integer id) {
		JsonResult json=new JsonResult();
		try {
			orderFormService.deleteOrder(id);
			json.setState(1);
			json.setMessage("删除成功");
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("删除失败");
		}
		return json;
	}
	
	
	@RequestMapping("/updateOrderStatus.do")
	@ResponseBody
	@ApiOperation(value = "修改订单状态", notes = "订单状态为0-3，对应0未支付，1待发货，2已发货，3已完成", httpMethod = "GET", response = JsonResult.class)
	public JsonResult updateOrderStatus (Integer id,Integer Status) {
		JsonResult json=new JsonResult();
		try {
			orderFormService.updateOrderStatus(id,Status);
			json.setState(1);
			json.setMessage("修改成功");
		} catch (Exception e) {	  
			json.setState(0);
			json.setMessage("修改失败");
		}
		return json;
	}
	
	
	@RequestMapping("/payOrder.do")
	@ResponseBody
	@ApiOperation(value = "支付订单", notes = "number为订单编号", httpMethod = "GET", response = JsonResult.class)
	public JsonResult payOrder(Long number,String openid) {
		JsonResult json=new JsonResult();
		try {
			orderFormService.payOrder(number,openid);
			json.setState(1);
			json.setMessage("支付成功");
		} catch (Exception e) {	  
			json.setState(0);
			json.setMessage(e.getMessage());
		}
		return json;
	}
	
}
