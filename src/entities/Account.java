package entities;

public class Account {
private Long id;
private Double balance;
public  static double DEPOSIT_FEE_PERCENTAGW =0.02;

public Account() {
	
}

public Account(Long id, Double balance) {
	super();
	this.id = id;
	this.balance = balance;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Double getBalance() {
	return balance;
}


public void deposit(double amount) {
	if(amount>0) {
		amount -= amount*DEPOSIT_FEE_PERCENTAGW;
		balance +=amount;
	}

	
}

public void withdraw(double amount) {
	if(amount > balance) {
		throw new IllegalArgumentException();
	}
	balance-=amount;
}


public double fullWithDraw() {
	double aux = balance;
	balance = 0.0;
	return aux;
}

}
