package com.pingan.smartsearch.jsoup;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	private static String PROXY = "http://www.boyunjian.com";
	private static String SEARCH_PROXY = PROXY + "/do/jarse/s.do?keyword=";
	
	public static JSONObject search (String keyword) {
		JSONObject result = new JSONObject();
		
		if (StringUtils.isEmpty(keyword)) {
			return result;
		}
		long start = System.currentTimeMillis();
		Document doc = null;
		try {
			doc = Jsoup.connect(SEARCH_PROXY + keyword).timeout(10 * 1000).get();
		} catch (IOException e) {
			e.printStackTrace();
			return result; 
		}
		System.out.println(System.currentTimeMillis() - start);
		Element resultElement = doc.getElementById("publicResultTable");
		if (resultElement == null) {
			return result;
		}
		
		parseSearchResult(result, resultElement);
		return result;
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
	
	public static void main(String[] args) {
		System.out.println(search("StringUtils").toString());
	}

}
