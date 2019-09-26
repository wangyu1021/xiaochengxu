package xcx.service;

import java.util.List;
import java.util.Map;

import xcx.pojo.UserAddress;

public interface UserService {

	void addUser(Map<String, Object> map);

	void addAddress(UserAddress userAddress);

	void deleteAddress(Integer id);

	List<UserAddress> findAddress(String openid);

	UserAddress findDefaultAddress();

	void updateDefaultAddress(Integer id);

	void updateBalance(String openid, Double balance);

}
