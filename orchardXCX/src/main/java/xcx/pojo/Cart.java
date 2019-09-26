package xcx.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2836506549822713920L;
	@ApiModelProperty(hidden = true)
	private Integer id;
	private Integer productId;
	private Integer num;
	private String  openid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", productId=" + productId + ", num=" + num + ", openid=" + openid + "]";
	}
	
}
