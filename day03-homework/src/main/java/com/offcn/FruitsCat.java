package com.offcn;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.model.Fruits;
import com.offcn.service.FruitsService;

public class FruitsCat {

	public static void main(String[] args) {
		String html="http://www.xinfadi.com.cn/marketanalysis/0/list/1.shtml?prodname=%E9%A6%99%E8%95%89&begintime=&endtime=";
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpGet get=new HttpGet(html);

		get.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");

		String s = null;
		List<Fruits> list = new ArrayList<Fruits>();
		try {
			CloseableHttpResponse response = client.execute(get);
			
			StatusLine statusLine = response.getStatusLine();
			
			HttpEntity eneity = response.getEntity();
			if(statusLine.getStatusCode() == 200)
			{
				s = EntityUtils.toString(eneity,"utf-8");
			}
			Document doc = Jsoup.parse(s);
			
			//·ÖÎöÊý¾Ý
			Element tableele = doc.getElementsByClass("hq_table").first();
			Element trele = tableele.getElementsByClass("tr_color").first();
			
				String row=trele.select("td").text();
				System.out.println(row);
				String[] values=row.split(" ");
				
				Fruits fruits = new Fruits();
				fruits.setName(values[0]);
				fruits.setMin(Double.parseDouble(values[1]));
				fruits.setAvg(Double.parseDouble(values[2]));
				fruits.setMax(Double.parseDouble(values[3]));
				fruits.setSpec(values[4]);
				fruits.setUnit(values[5]);
				
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
				fruits.setTime(sf.parse(values[6]));
				

				list.add(fruits);
				
				 ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
				 
				 FruitsService fruitsService = (FruitsService) context.getBean("fruitsServiceImple");
				 for (Fruits fru : list) {
					 fruitsService.saveFruits(fru);
				}


		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static List<Fruits> parsHtml(String html) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String catUrlToString(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
