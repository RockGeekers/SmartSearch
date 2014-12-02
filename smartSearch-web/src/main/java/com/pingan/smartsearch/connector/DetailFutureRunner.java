package com.pingan.smartsearch.connector;

import java.util.concurrent.Callable;

import net.sf.json.JSONObject;

import com.pingan.smartsearch.bean.ArtifactBean;

public class DetailFutureRunner implements Callable<JSONObject> {

	private SearchConnector connector;
	private ArtifactBean artifact;
	
	public DetailFutureRunner(SearchConnector connector, ArtifactBean artifact) {
		this.connector = connector;
		this.artifact = artifact;
	}
	
	@Override
	public JSONObject call() throws Exception {
		return connector.detail(artifact);
	}

	
}
