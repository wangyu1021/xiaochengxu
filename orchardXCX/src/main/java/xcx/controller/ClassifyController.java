package xcx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import xcx.pojo.Classify;
import xcx.pojo.JsonResult;
import xcx.service.ClassifyService;


@CrossOrigin
@Controller
@RequestMapping("/classify")
@Api(value = "/classify" ,tags="分类")
public class ClassifyController {
	@Autowired
	private ClassifyService classifyService;
	
	@RequestMapping("/findClassify.do")
	@ResponseBody
	@ApiOperation(value = "获取所有分类", notes = "获取所有分类", httpMethod = "GET", response = JsonResult.class)
	public JsonResult findClassify() {
		JsonResult json=new JsonResult();
		try {
			List<Classify> list=classifyService.findClassify();
			json.setState(1);
			json.setData(list);
		} catch (Exception e) {
			json.setState(0);
			json.setMessage("出错了，稍后再试");
		}
		return json;
	}
}
