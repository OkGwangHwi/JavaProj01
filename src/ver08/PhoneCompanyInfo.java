package ver08;

public class PhoneCompanyInfo extends PhoneInfo{

	private String cpName;
	
	
	public PhoneCompanyInfo(String name,String phoneNumber,
			String cpName) {
		super(name,phoneNumber);
		
		this.cpName =cpName;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("회사:"+cpName);
	}
	
}
