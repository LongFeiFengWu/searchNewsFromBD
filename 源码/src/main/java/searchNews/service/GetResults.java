package searchNews.service;

import searchNews.model.NewsInfos;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetResults {

	// 百度搜索
	private String urll = "http://news.baidu.com/ns?word=";

	public List<NewsInfos> getNews(String key, int num) throws Exception {

		List<NewsInfos> newsInfos = new ArrayList<NewsInfos>();
		
		String url = urll + URLEncoder.encode(key, "utf-8") + "&rn=" + num;
	    //String str = System.Web.HttpUtility.UrlEncode(key, System.Text.UnicodeEncoding.GetEncoding("GB2312")).ToUpper();
		//String url = urll + key + "&rn=" + num;
        
		Document doc = Jsoup.connect(url).get();

		// Element element = doc.getElementById("content_left");
		Element element = doc.select("div#content_left").first();

		for (int i = 1; i < (num + 1); i++) {

			NewsInfos infos = new NewsInfos();
			// Element result = element.getElementById(String.valueOf(i));
			Element result = element.select("div#" + String.valueOf(i) + ".result").first();

			String title = "";
			String link = "";

			String authData = "";

			Elements add = result.select("a");

			title = add.first().text();
			link = add.first().attr("href");
			authData = result.select("p").first().text();

			infos.setAuthInfo(authData);
			infos.setLink(link);
			infos.setTitle(title);

			newsInfos.add(infos);
		}

		return newsInfos;
	}

	public List<String> getNewsList(String key, int num) throws Exception {

		List<String> newsInfos = new ArrayList<String>();

		String url = urll + URLEncoder.encode(key, "utf-8") + "&rn=" + num;

		Document doc = Jsoup.connect(url).get();
		Element element = doc.getElementById("content_left");

		for (int i = 1; i < (num + 1); i++) {

			Element result = element.getElementById(String.valueOf(i));

			Elements add = result.select("a");

			String title = add.first().text();
			String link = add.first().attr("href");

			String authData = result.select("p").first().text();
			newsInfos.add(title + "    " + authData + "    " + "    " + link);
		}
		return newsInfos;
	}
}
