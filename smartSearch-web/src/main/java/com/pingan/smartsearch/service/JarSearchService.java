package com.pingan.smartsearch.service;

import net.sf.json.JSONObject;

public interface JarSearchService {
	public JSONObject search(String keyword);
	
	public JSONObject detail(String groupId, String artifactId);
}
