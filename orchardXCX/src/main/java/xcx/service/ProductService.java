package xcx.service;

import java.util.List;

import xcx.pojo.Product;

public interface ProductService {


	List<Product> findProductByName(String name);


	List<Product> findProduct();

	List<Product> findProductByClassifyId(Integer classifyId);
}
