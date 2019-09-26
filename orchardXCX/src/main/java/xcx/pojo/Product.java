package xcx.pojo;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * 	商品
 * @author Riyas
 *
 */
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4281480361260371897L;
	@ApiModelProperty(hidden = true)
	private Integer id;
	@ApiModelProperty(hidden = true)
	private String number;//编号
	private Integer classifyId;
	private String name;
	private Double price;
	private String information;//简介
	@ApiModelProperty(hidden = true)
	private String image;//图片保存地址
	private Integer num;//数量
	private String specification;//规格
	private String origin;//起源地
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", number=" + number + ", classifyId=" + classifyId + ", name=" + name + ", price="
				+ price + ", information=" + information + ", image=" + image + ", num=" + num + ", specification="
				+ specification + ", origin=" + origin + "]";
	}
	
}
