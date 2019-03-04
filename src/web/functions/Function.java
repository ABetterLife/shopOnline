package web.functions;

import domain.Category;
import sevice.BusinessService;
import sevice.impl.BusinessServiceImpl;

public class Function {
	public static String getCategoryNameById(String category_id) {
		BusinessService bs=new BusinessServiceImpl();
		Category category=bs.findCategoryById(category_id);
		if(category!=null) {
			return category.getName();
		}
		return "";
		
		
	}

}
