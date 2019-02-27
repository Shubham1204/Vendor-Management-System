import java.io.Serializable;


public class Vendor implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String company;
	private String address;
	private String software;

	Vendor(){ };
	
	Vendor(String name, String company, String address, String software){
		this.name = name;
		this.company = company;
		this.address = address;
		this.software = software;
	}
	
	Vendor(String name){
		this.name=name;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nCompany: " + company + "\nAddress: " + address + "\nSoftware: " + software; 
	}
	
	
	public String Name() {
		return name;
	}
	
	public String company() {
		return company;
	}
	
	public String Address() {
		return address;
	}
	
	public String Software() {
		return software;
	}
}


