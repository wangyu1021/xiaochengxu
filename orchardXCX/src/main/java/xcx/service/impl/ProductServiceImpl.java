package xcx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xcx.dao.ProductDao;
import xcx.pojo.Product;
import xcx.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

	public List<Product> findProductByName(String name) {
		List<Product> list = productDao.selectProductByName(name);
		if(list==null) {
			throw new RuntimeException("没有记录");
		}
		return list;
	}

	public List<Product> findProduct() {
		List<Product> list = productDao.selectProduct();
		if(list.size()==0){
			throw new IllegalArgumentException("商品正在来的路上");
		}
		return list;
	}

	public List<Product> findProductByClassifyId(Integer classifyId) {
		List<Product> list=productDao.selectProductByClassifyId(classifyId);
		return list;
	}
}
