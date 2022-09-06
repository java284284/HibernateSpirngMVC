package tw.ispan.springdemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CompanySoGo {
	
	@Autowired
	@Qualifier("creditCardHappy")
	private CreditCard creditCard;

	public CompanySoGo() {
	}
	
	public void userCard() {
		creditCard.userCard("來 SoGo 刷卡送雨傘");
	}

}