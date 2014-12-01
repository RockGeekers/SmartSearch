package com.pingan.smartsearch.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1);
		
		Document doc = null;
		String url = "http://www.boyunjian.com/do/jarse/s.do?keyword=jsoup";
		
		try {
			doc = Jsoup.connect(url).timeout(5000).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element searchResult = doc.getElementById("publicResult");
		System.out.println(searchResult.toString());
	}

}
