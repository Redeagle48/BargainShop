package Runner;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import DatabaseConnection.ConnectDB;

public class Run {

	public static void main(String[] args) {

		Document doc, doc2;
		try {
			doc = Jsoup.connect("http://www.continente.pt/stores/continente/pt-pt/public/Pages/ProductDetail.aspx?ProductId=2807599(eCsf_RetekProductCatalog_MegastoreContinenteOnline_Continente)").get();
			doc2 = Jsoup.connect("http://www.jumbo.pt/Frontoffice/ContentPages/CatalogProduct.aspx?id=12150").get();

			Element item = doc.select("#contentMain .contentLeftTop .productDetailArea .productTitle").first();
			Element price = doc.select("#contentMain .contentLeftTop .productDetailArea .productInfoRight .productPricingDescription .updListPrice").first();

			Element item2 = doc2.select(".titProd").first();
			Element price2 = doc2.select(".preco").first();

			System.out.println("Item's name: " + item.text());
			System.out.println("Price is: " + price.text());

			System.out.println("Item's name: " + item2.text());
			System.out.println("Price is: " + price2.text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnectDB connectdb = new ConnectDB();
		connectdb.testConnect();
	}
}