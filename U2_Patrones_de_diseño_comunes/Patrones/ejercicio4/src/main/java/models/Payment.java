package models;

public class Payment {

	private final Integer customerNumber;
	private final String checkNumber;
	private final String paymentDate;
	private final Double amount;
	
	
	public Payment(Integer customerNumber, String checkNumber, String paymentDate, Double amount) {
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	public Integer getCustomerNumber() {
		return customerNumber;
	}


	public String getCheckNumber() {
		return checkNumber;
	}


	public String getPaymentDate() {
		return paymentDate;
	}


	public Double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Payment [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}
	
}
