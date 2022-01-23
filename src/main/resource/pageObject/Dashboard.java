package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utils.CommonUtility;

public class Dashboard extends CommonUtility {

	private  final By ordertotal=By.xpath("//h3[normalize-space()='Order totals']");
	private  final By orderStatus=By.xpath("//table[@id='average-order-report-grid']//tr//td[1]");
	
	public Dashboard getOrderDetails() {
		scroll(ordertotal);
		List<WebElement> AllOrderStatus=findelements(orderStatus);
		for (WebElement element : AllOrderStatus) {
			String text=element.getText();
			System.out.println(text);
			
		}
		return this;
	}
}
