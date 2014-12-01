package com.pingan.smartsearch.connector.jsoup;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.pingan.smartsearch.connector.SearchConnector;

public class JsoupSearchConnector implements SearchConnector {

	private final static String PROXY = "http://www.boyunjian.com";
	private final static String SEARCH_PROXY_URL = PROXY + "/do/jarse/s.do?keyword=";
	private final static int TIME_OUT = 10 * 1000;
	
	@Override
	public JSONObject search(String keyword) {
		JSONObject result = new JSONObject();

		Document doc = connect(SEARCH_PROXY_URL + keyword);
		if (doc == null) {
			return result;
		}
		
		Element resultElement = doc.getElementById("publicResultTable");
		if (resultElement == null) {
			return result;
		}
		
		parseSearchResult(result, resultElement);
		return result;
	}
	
	private Document connect(String url) {
		Document doc = null;
		try {
			Connection conn = Jsoup.connect(url);
			conn.timeout(TIME_OUT);
			conn.ignoreHttpErrors(true);
			conn.ignoreContentType(true);
			doc = conn.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	private static void parseSearchResult(JSONObject result, final Element resultElement) {
		Elements trElements = resultElement.child(0).children();
		
		String groupId = null;
		for (int i = 2; i < trElements.size(); i ++) {
			
			Element trElement = trElements.get(i);
			Elements tdElements = trElement.children();
			Element versionElement, artifactIdElement;
			if (tdElements.size() == 3) {
				Element groupIdElement = tdElements.get(0);
				groupId = groupIdElement.text();
				versionElement = tdElements.get(1);
				artifactIdElement = tdElements.get(2);
			} else {
				versionElement = tdElements.get(0);
				artifactIdElement = tdElements.get(1);
			}
			
			parseArtifact(result, groupId, versionElement, artifactIdElement);
		}
	}
	
	private static void parseArtifact(JSONObject result, String groupId, final Element versionElement, final Element artifactIdElement) {
		if (!result.containsKey(groupId)) {
			JSONObject groupIdJson = new JSONObject();
			result.put(groupId, groupIdJson);
		}
		
		JSONObject groupIdJson = result.getJSONObject(groupId);
		String version = versionElement.text();
		String artifactId = artifactIdElement.getElementsByClass("artifactA").text();
		groupIdJson.put(version, artifactId);
	}
}
