package xcx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xcx.dao.ClassifyDao;
import xcx.pojo.Classify;
import xcx.service.ClassifyService;

@Service
public class ClassifyServiceImpl implements ClassifyService {
	@Autowired
	private ClassifyDao classifyDao;
	
	
	public List<Classify> findClassify() {
		List<Classify> list=classifyDao.selectClassify();
		return list;
	}

}
