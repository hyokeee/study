package kr.or.ddit.basic;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawling01 {
	public static void main(String[] args) throws IOException {
		
		String url = "https://finance.naver.com/item/main.naver?code=005930";
		
		Document doc = Jsoup.connect(url).get();
		
		//너무 많아서 짤려 나옴
		//==>필요한 부분을 입력해 구해야함
		//class값이 no_today인 값을 가져와줘!
		//class값은 여러개가 올 수 있으므로 Elements!! / ByAttributeValue("속성","값") 여기선 클래스- 클래스명
		Elements e1 = doc.getElementsByAttributeValue("class","no_today");
		System.out.println(e1);
		//span 태그 사이에 입력된 주식 값 을 가져오려면 ? .text
		//System.out.println(e1.text());
		//값이 2개로 나오면 -> 그 중 몇번째 껄 가져오겠다
		Element e2 = e1.get(0);
		
		String price = e2.select(".blind").text();
		System.out.println(price);
	}
}
