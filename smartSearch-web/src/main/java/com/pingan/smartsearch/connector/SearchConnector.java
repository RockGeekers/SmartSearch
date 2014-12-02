package com.pingan.smartsearch.connector;

import net.sf.json.JSONObject;

import com.pingan.smartsearch.bean.ArtifactBean;

public interface SearchConnector {
	
	public JSONObject search(String keyword);
	
	public JSONObject detail(ArtifactBean artifact);

}
