package xcx.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import xcx.pojo.Product;
@Component
public interface ProductDao {


	List<Product> selectProductByName(String name);

	List<Product> selectProduct();

	Product selectProductById(Integer productId);

	List<Product> selectProductByClassifyId(Integer classifyId);
}
