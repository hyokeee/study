package kr.or.ddit.basic;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawling02 {
    public static void main(String[] args) throws IOException {
        String url = "https://movie.daum.net/premovie/theater";
		
		Document doc = Jsoup.connect(url).get();
		
		//너무 많아서 짤려 나옴
		//==>필요한 부분을 입력해 구해야함
		//class값이 no_today인 값을 가져와줘!
		//class값은 여러개가 올 수 있으므로 Elements!! / ByAttributeValue("속성","값") 여기선 클래스- 클래스명
		Elements e1 = doc.getElementsByClass("item_poster");
		System.out.println(e1);
		//span 태그 사이에 입력된 주식 값 을 가져오려면 ? .text
		//System.out.println(e1.text());
		//값이 2개로 나오면 -> 그 중 몇번째 껄 가져오겠다
		Element e2 = e1.get(1);
		
		String price = e2.select("link_txt").text();
		System.out.println(price);
    }
}
