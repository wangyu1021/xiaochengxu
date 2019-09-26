package xcx.pojo;

import java.io.Serializable;

public class Classify implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6666280116639317426L;
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
