package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		double amount = 200.0;
		double ExpetedValue = 196.0;
		
		Account acc = AccountFactory.createEmptyAccount();
		acc.deposit(amount);
		
		Assertions.assertEquals(ExpetedValue, acc.getBalance());
		
		
	}
	
	@Test
	 public void depositShouldDoNothingWhenNegativeAmount() {
	
		double ExpetedValue = 200;
		Account acc = AccountFactory.createAccount(ExpetedValue);
		double amount = -200;
		acc.deposit(amount);
		Assertions.assertEquals(ExpetedValue, acc.getBalance());
		
	}
	@Test
	public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
		double expetedValue = 0.0;
		double initialBalance =800.0;
		Account acc = AccountFactory.createAccount(800.0);
		
		double result = acc.fullWithDraw();
		
		Assertions.assertEquals(expetedValue, acc.getBalance());
		Assertions.assertTrue(result==initialBalance);

		
	}
    
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		Account acc = AccountFactory.createAccount(800.0);
		acc.withdraw(500.00);
		

		Assertions.assertEquals(300.0, acc.getBalance());
	}
	@Test
	public void withdrawShouldThrowExceptionWhenInsifficientBalance() {
	
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(801.0);
			
		});
	}
	
	
	
}
