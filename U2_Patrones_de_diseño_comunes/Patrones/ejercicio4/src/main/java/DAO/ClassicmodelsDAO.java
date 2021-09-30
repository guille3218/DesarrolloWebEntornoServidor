package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import SingletonDB.DBConnection;
import models.Payment;

public class ClassicmodelsDAO {
	public static List<Payment> getPayments(){
		Connection con = DBConnection.getConnection();
		ArrayList<Payment> lista_payments = new ArrayList<Payment>();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from payments");
			
			while(rs.next()) {
				Payment p = new Payment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				lista_payments.add(p);
			}
			
			
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		return lista_payments;
		
	}
	
	public static boolean createPayment(Integer customerNumber, String checkNumber, String paymentDate, Double amount) {
		
		Connection con = DBConnection.getConnection();
		List<Payment> p1 = ClassicmodelsDAO.getPayments();
		
		Payment p = new Payment(customerNumber, checkNumber, paymentDate, amount);
		
		for (Payment payment : p1) {
			if(payment.getCustomerNumber().equals(p.getCustomerNumber()) && payment.getCheckNumber().equals(p.getCheckNumber())
					&& payment.getPaymentDate().equals(p.getPaymentDate()) && payment.getAmount().equals(p.getAmount())) {
				System.out.println("Ya existe ese Payment.");
				return false;
			}
		}
				try {
					PreparedStatement pstmt = con.prepareStatement("INSERT INTO payments(customerNumber,checkNumber,paymentDate,amount) VALUES ('"+customerNumber+"','"+checkNumber+"','"+paymentDate+"','"+amount+"')");
					pstmt.executeUpdate();
					System.out.println("Se ha introducido correctamente");
					return true;
				} catch(SQLException e) {
					e.printStackTrace();
				
				}
		
		return false;
	}
		
}
