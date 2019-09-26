package xcx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import xcx.pojo.JsonResult;
import xcx.pojo.UserAddress;
import xcx.service.UserService;

@CrossOrigin
@Controller
@Api(tags="小程序登录/用户接口")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	@ResponseBody
	@ApiOperation(value = "小程序登录接口", notes = "小程序登录接口", httpMethod = "GET", response = Map.class)
	public  Map<String, Object> getWxUserOpenid(String code,String nickName,String avatarUrl) {
		//拼接url
		StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
		url.append("appid=wx0fd2b5c7735513d9");//appid设置
		url.append("&secret=36d1321b899ced43693fd8ec0c5a23fb");//secret设置
		url.append("&js_code=");//code设置
		url.append(code);
		url.append("&grant_type=authorization_code");
		Map<String, Object> map = null;
		try {
			HttpClient client =HttpClientBuilder.create().build();//构建一个Client
			HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
			HttpResponse response = client.execute(get);//提交GET请求
			HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
			String content = EntityUtils.toString(result);   
			System.out.println(content);//打印返回的信息
			JSONObject res = JSONObject.fromObject(content);//把信息封装为json
			//把信息封装到map
			map = UserController.parseJSON2Map(res);//这个小工具的代码在下面
			map.put("nickName", nickName);
			map.put("avatarUrl",avatarUrl);
			userService.addUser(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public static Map<String, Object> parseJSON2Map(JSONObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				@SuppressWarnings("unchecked")
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}
	
	public JsonResult updateBalance(String openid,Double balance) {
		JsonResult json=new JsonResult();
		try {
			userService.updateBalance(openid,balance);
			json.setState(1);
			json.setMessage("充值成功");
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("充值失败");
		}
		return json;
	}
	
	@RequestMapping("/addAddress.do")
	@ResponseBody
	@ApiOperation(value = "添加地址", notes = "添加地址", httpMethod = "POST", response = JsonResult.class)
	public JsonResult addAddress(@RequestBody UserAddress userAddress) {
		JsonResult json=new JsonResult();
		try {
			userService.addAddress(userAddress);
			json.setState(1);
			json.setMessage("添加成功");
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("添加失败");
		}
		return json;
	}

	@RequestMapping("/deleteAddress.do")
	@ResponseBody
	@ApiOperation(value = "删除地址", notes = "删除地址", httpMethod = "GET", response = JsonResult.class)
	public JsonResult deleteAddress(Integer id) {
		JsonResult json=new JsonResult();
		try {
			userService.deleteAddress(id);
			json.setState(1);
			json.setMessage("删除成功");
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("删除失败");
		}
		return json;
	}


	@RequestMapping("/findAddress.do")
	@ResponseBody
	@ApiOperation(value = "获取地址", notes = "获取地址", httpMethod = "GET", response = JsonResult.class)
	public JsonResult findAddress(String openid) {
		JsonResult json=new JsonResult();
		try {
			List<UserAddress> list= userService.findAddress(openid);
			json.setState(1);
			json.setData(list);;
		} catch (Exception e) {
			json.setState(0);
		}
		return json;
	}
	@RequestMapping("/findDefaultAddress.do")
	@ResponseBody
	@ApiOperation(value = "获取默认地址", notes = "获取默认地址", httpMethod = "GET", response = JsonResult.class)
	public JsonResult findDefaultAddress() {
		JsonResult json=new JsonResult();
		try {
			UserAddress address= userService.findDefaultAddress();
			json.setState(1);
			json.setData(address);
		} catch (Exception e) {
			json.setState(0);
			json.setMessage(e.getMessage());
		}
		return json;
	}

	@RequestMapping("/updateDefaultAddress.do")
	@ResponseBody
	@ApiOperation(value = "修改默认地址", notes = "状态码status，1为默认地址，0为非默认地址,值只有0或1", httpMethod = "GET", response = JsonResult.class)
	public JsonResult updateDefaultAddress(Integer id) {
		JsonResult json=new JsonResult();
		try {
			userService.updateDefaultAddress(id);
			json.setState(1);
			json.setMessage("修改成功");
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("修改失败");
		}
		return json;
	}
}
