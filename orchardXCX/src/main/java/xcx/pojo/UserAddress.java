package xcx.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class UserAddress implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4752256532756659688L;
	@ApiModelProperty(hidden = true)
	private Integer id;
	private String openid;
	private String name;
	private Long phone;
	private String address;
	@ApiModelProperty(hidden = true)
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
