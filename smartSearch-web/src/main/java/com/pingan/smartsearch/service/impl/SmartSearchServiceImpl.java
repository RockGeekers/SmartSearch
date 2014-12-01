package com.pingan.smartsearch.service.impl;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import net.sf.json.JSONObject;

import com.pingan.smartsearch.connector.SearchConnector;
import com.pingan.smartsearch.connector.SearchFutureRunner;
import com.pingan.smartsearch.service.SmartSearchService;

public class SmartSearchServiceImpl implements SmartSearchService {

	private final ExecutorService threadPool = Executors.newCachedThreadPool();
	private SearchConnector searchConnector;

	public JSONObject search(String keyword) {
		FutureTask<JSONObject> future = new FutureTask<JSONObject>(
				new SearchFutureRunner(searchConnector, keyword));
		threadPool.execute(future);

		try {
			return future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void setSearchConnector(SearchConnector searchConnector) {
		this.searchConnector = searchConnector;
	}
}
