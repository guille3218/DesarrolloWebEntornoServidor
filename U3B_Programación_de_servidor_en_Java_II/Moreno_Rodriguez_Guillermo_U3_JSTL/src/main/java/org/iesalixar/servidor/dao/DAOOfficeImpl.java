package org.iesalixar.servidor.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.bd.ConexionBD;
import org.iesalixar.servidor.model.Office;

public class DAOOfficeImpl implements DAOOffice {
	
	@Override
	public List<Office> getAllOffices(){
		ArrayList<Office> officesList = new ArrayList<>();

		
		try {
			String sql = "select * from offices";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Office office = new Office();
				
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));
				
				officesList.add(office);
			}
			
			ConexionBD.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return officesList;
	}

	@Override
	public Office getOffice(String city) {
		Office office = null;
		
		try {
			String sql = "select * from offices where city= ?";
			PreparedStatement statement = ConexionBD.getConnection().prepareStatement(sql);
			
			statement.setString(1, city);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				office = new Office();
				
				office.setOfficeCode(rs.getString("officeCode"));
				office.setCity(rs.getString("city"));
				office.setPhone(rs.getString("phone"));
				office.setAddressLine1(rs.getString("addressLine1"));
				office.setAddressLine2(rs.getString("addressLine2"));
				office.setState(rs.getString("state"));
				office.setCountry(rs.getString("country"));
				office.setPostalCode(rs.getString("postalCode"));
				office.setTerritory(rs.getString("territory"));
				
			}
			
			ConexionBD.close();
			
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return office;
	}
}
