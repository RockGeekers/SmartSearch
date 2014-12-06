package com.pingan.smartsearch.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pingan.smartsearch.service.JarSearchService;

@Controller
@RequestMapping (value="/jar")
public class JarSearchController {

	public void setJarSearchService(JarSearchService jarSearchService) {
		this.jarSearchService = jarSearchService;
	}

	@Autowired
	private JarSearchService jarSearchService;
	
	@RequestMapping (value="/search/{keyword}", method=RequestMethod.GET)
	public void searchKeyword(HttpServletResponse response, @PathVariable String keyword) throws IOException {
		JSONObject result = jarSearchService.search(keyword);
		response.getWriter().write(result.toString());
		response.flushBuffer();
	}
	
	@RequestMapping (value="/detail/{group}/{artifact}", method=RequestMethod.GET)
	public void getDetail(HttpServletResponse response, 
						@PathVariable String group, @PathVariable String artifact) throws IOException {
		JSONObject result = jarSearchService.detail(group, artifact);
		response.getWriter().write(result.toString());
		response.flushBuffer();
	}
	
}
