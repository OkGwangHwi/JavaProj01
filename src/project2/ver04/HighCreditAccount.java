package project2.ver04;

public class HighCreditAccount extends Account implements CustomSpecialRate{
	private int add,ratingAdd;
	private String rating;

	public HighCreditAccount(String accountNumber, String name, int balance, int add, String rating) {
		super(accountNumber, name, balance);
		this.add = add;
		this.rating = rating;
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : "+add+"%");
		System.out.println("신용등급 : "+ratingAdd+"%");

	}
	
	public void balanceDeposit(int deposit) {
		int Credit=0;
		
		if(rating.equals("A")) {
			Credit = CustomSpecialRate.A;
		}else if(rating.equals("B")) {
			Credit = CustomSpecialRate.B;
		}else if(rating.equals("C")) {
			Credit = CustomSpecialRate.C;
		}
		
		balance = balance + (balance * add)/100 
				+(balance * Credit)/100 + deposit;
	}

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}
}
