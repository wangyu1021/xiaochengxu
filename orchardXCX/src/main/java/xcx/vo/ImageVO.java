package xcx.vo;

import java.io.Serializable;

public class ImageVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2553312961459574168L;
	private Integer error;  //0.表示成功  1.表示失败	
	private String  url;
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "ImageVO [error=" + error + ", url=" + url + "]";
	}
	
	
}
