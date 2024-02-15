package com.servletindex;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
public class IndexController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		Map map = new HashMap();
		map.put("resolver", "InternalResourceViewResolver");
		map.put("message", "index : " + name);
		
		ModelAndView modelAndView = new ModelAndView("success", map);
		return modelAndView;
	}
}