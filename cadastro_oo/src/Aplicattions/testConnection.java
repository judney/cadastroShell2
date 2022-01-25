package Aplicattions;

import java.sql.Connection;

import db.DB;

public class testConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection conn = DB.getConnection();

	}

}
