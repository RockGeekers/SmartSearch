package com.pingan.smartsearch.connector;

import java.util.concurrent.Callable;
import net.sf.json.JSONObject;

public class SearchFutureRunner implements Callable<JSONObject> {

	private SearchConnector connector;
	private String keyword;

	public SearchFutureRunner(final SearchConnector connector, String keyword) {
		this.connector = connector;
		this.keyword = keyword;
	}
	
	@Override
	public JSONObject call() throws Exception {
		return connector.search(keyword);
	}

}
