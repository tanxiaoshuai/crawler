package cn.wodesh;

import cn.wodesh.service.NeteaseServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerMserverApplicationTests {

	@Autowired
	private NeteaseServiceImpl service;

	@Test
	public void contextLoads() throws Exception {

		System.out.println(JSONArray.toJSON(service.getHtmlUrl("http://news.163.com" , "^(.*\\.html)$" , "新闻")));
	}

}
