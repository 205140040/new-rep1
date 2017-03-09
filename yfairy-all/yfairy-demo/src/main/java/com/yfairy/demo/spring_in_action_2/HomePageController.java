package com.yfairy.demo.spring_in_action_2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HomePageController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelandview = new ModelAndView("springInAction2Page");
		String name = request.getParameter("name");
		modelandview.addObject("name", name);
		System.out.println("getViewName:" + modelandview.getViewName());
		// if (true) {
		// throw new Exception("eee");
		// }
		return modelandview;
	}

}
