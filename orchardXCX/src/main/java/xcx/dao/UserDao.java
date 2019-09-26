package xcx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import xcx.pojo.User;
import xcx.pojo.UserAddress;

public interface UserDao {

	void insertUser(User user);

	User selectUserByOpenId(String openid);

	void updateUser(User user);

	void addAddress(UserAddress userAddress);

	void deleteAddress(Integer id);

	List<UserAddress> findAddress(String openid);

	UserAddress selectDefaultAddress();

	void updateDefaultAddress(Integer id);

	void updateAddress();

	void updateBalance(@Param("b")Double b, @Param("openid")String openid);
}
