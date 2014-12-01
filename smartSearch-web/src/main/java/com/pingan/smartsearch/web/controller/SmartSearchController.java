package com.pingan.smartsearch.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pingan.smartsearch.service.SmartSearchService;

@Controller
@RequestMapping (value="/jar")
public class SmartSearchController {

	public void setSearchService(SmartSearchService searchService) {
		this.searchService = searchService;
	}

	@Autowired
	private SmartSearchService searchService;
	
	@RequestMapping (value="/search", method=RequestMethod.GET)
	public void searchKeyword(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String keyword = request.getParameter("keyword");
		
		JSONObject result = searchService.search(keyword);
		response.getWriter().write(result.toString());
		response.flushBuffer();
	}
	
}
