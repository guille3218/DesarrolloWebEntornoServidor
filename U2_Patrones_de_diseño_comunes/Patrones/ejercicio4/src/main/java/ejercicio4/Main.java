package ejercicio4;

import DAO.ClassicmodelsDAO;
import SingletonDB.DBConnection;

public class Main {
	
	public static void main(String[] args) {
		
		
		System.out.println(ClassicmodelsDAO.getPayments());
		
		ClassicmodelsDAO.createPayment(168, "ED743615", "2004-09-19", 12538.01);
		
		DBConnection.close();
	}
}
