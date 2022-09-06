package tw.ispan.springdemo.model;

import org.springframework.stereotype.Component;

@Component
public class CreditCardHappy implements CreditCard {

	public CreditCardHappy() {
	}

	@Override
	public void userCard(String message) {
		System.out.println("Happy Card: " + message);

	}

}