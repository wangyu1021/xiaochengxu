package xcx.util;

import java.util.ArrayList;
import java.util.List;

public abstract class ReplaceNullUtil {
	public static String[] replaceNull(String[] str) {
		  List<String> tmp = new ArrayList<String>();
	        for(String str1:str){
	            if(str1!=null && str1.length()!=0){
	                tmp.add(str1);
	            }
	        }
	        str = tmp.toArray(new String[0]);
	        return str;
	}
}
