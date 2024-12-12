package RestDemo;

import java.util.List;

public class MutlipleArray {
	private String id;
	private String customerName;
	private String email;
	private List<String> phoneNos; 
	private String orderId;

	public MutlipleArray(String id, String customerName, String email, List<String> phoneNos, String orderId) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.phoneNos = phoneNos;
		this.orderId = orderId;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNos() {
		return phoneNos;
	}

	public void setPhoneNos(List<String> phoneNos) {
		this.phoneNos = phoneNos;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
