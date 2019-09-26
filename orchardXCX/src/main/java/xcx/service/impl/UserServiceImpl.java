package xcx.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xcx.dao.UserDao;
import xcx.pojo.User;
import xcx.pojo.UserAddress;
import xcx.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	public void addUser(Map<String, Object> map) {
		User user=new User();
		String openid=(String) map.get("openid");
		String nickName=(String) map.get("nickName");
		String avatarUrl=(String) map.get("avatarUrl");
		user.setOpenid(openid);
		user.setNickName(nickName);
		user.setAvatarUrl(avatarUrl);
		User usr=userDao.selectUserByOpenId(openid);
		if(usr!=null) {
			userDao.updateUser(user);
		}else{
			userDao.insertUser(user);
		}
	}

	public void addAddress(UserAddress userAddress) {
		userDao.addAddress(userAddress);
	}

	public void deleteAddress(Integer id) {
		userDao.deleteAddress(id);
	}

	public List<UserAddress> findAddress(String openid) {
		List<UserAddress> list =userDao.findAddress(openid);
		if(list.size()==0) {
			throw new RuntimeException("没有地址");
		}
		return list;
	}

	public UserAddress findDefaultAddress() {
		return userDao.selectDefaultAddress();
	}

	public void updateDefaultAddress(Integer id) {
		try {
			userDao.updateAddress();
			Thread.sleep(500);
			userDao.updateDefaultAddress(id);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void updateBalance(String openid, Double balance) {
		userDao.updateBalance(balance,openid);
	}

}
