package searchNews.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import searchNews.model.NewsInfos;
import searchNews.service.GetResults;

@Controller
public class SearchController {

	private static String[] keys = {};
	private static int num = 10;

	@RequestMapping("/search")
	public String search(Map<String, Object> map) throws Exception {
		
		 FileInputStream fis = new FileInputStream("D:\\search.txt"); 
	     InputStreamReader isr = new InputStreamReader(fis, "UTF-8"); 
	        
		BufferedReader reader = null;
		String temp = null;
		try {
			reader = new BufferedReader(isr);
			while ((temp = reader.readLine()) != null) {
				keys = temp.split(",");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		map.put("keys", keys);
		Map<String, List<NewsInfos>> newsInfosMap = new LinkedHashMap<String, List<NewsInfos>>();

		long startTime = System.currentTimeMillis();// 记录开始时间

		for (String key : keys) {

			GetResults getResults = new GetResults();
			List<NewsInfos> infos = getResults.getNews(key, num);
			newsInfosMap.put(key, infos);
		}
		map.put("newsInfosMap", newsInfosMap);
		long endTime = System.currentTimeMillis();// 记录结束时间
		float excTime = (float) (endTime - startTime) / 1000;

		map.put("excTime", excTime);

		return "search";

	}

}
