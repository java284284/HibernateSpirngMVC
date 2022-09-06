package tw.ispan.springdemo.model;

import org.springframework.stereotype.Component;

@Component
public class CreditCardGoGo implements CreditCard {

	public CreditCardGoGo() {
	}

	@Override
	public void userCard(String message) {
		System.out.println("GOGO Card: " + message);
	}

}