package com.pingan.smartsearch.connector;

import net.sf.json.JSONObject;

public interface SearchConnector {
	
	public JSONObject search(String keyword);

}
