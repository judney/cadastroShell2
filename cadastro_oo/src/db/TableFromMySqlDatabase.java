

package db;
//import Java.awt.*;
//import Java.sql.*;
//import Java.util.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

//public class TableFromMySqlDatabase extends JFrame

public class TableFromMySqlDatabase extends JInternalFrame
{
    //public static final Component table = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TableFromMySqlDatabase()
    {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        //public JTable table = new JTable() ; 

        //  Connect to an MySQL Database, run query, get result set
        String url = "jdbc:mysql://localhost:3306/sys001";
        String userid = "root";
        String password = "hunter";
        String sql = "SELECT "
        		+ "substr(codigo,1,3) 'Codigo' , "
        		+ "trim(nome) Nome,   "
        		+ "trim(Documento) Documento   "
        		+ "FROM clientes "
        		+ "order by codigo   ";

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program 
        // is finished with them
        try (Connection connection = DriverManager.getConnection( url, userid, password );
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql ))
        {
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            for (int i = 1; i <= columns; i++)
            {
                columnNames.add( md.getColumnName(i) );
            }

            //  Get row data
            while (rs.next())
            {
                ArrayList row = new ArrayList(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.add( rs.getObject(i) );
                }

                data.add( row );
            }
        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }

        // Create Vectors and copy over elements from ArrayLists to them
        // Vector is deprecated but I am using them in this example to keep 
        // things simple - the best practice would be to create a custom defined
        // class which inherits from the AbstractTableModel class
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();

        for (int i = 0; i < data.size(); i++)
        {
            ArrayList subArray = (ArrayList)data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++)
            {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }

        for (int i = 0; i < columnNames.size(); i++ )
            columnNamesVector.add(columnNames.get(i));

        //  Create table with database data    
        JTable table = new JTable(dataVector, columnNamesVector)
        {
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        int vColIndex = 0 ; 
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);        // Configura a largura para 100 pixels
        TableColumn col = table.getColumnModel().getColumn(vColIndex);
        

        table.getColumnModel().getColumn(0).setPreferredWidth(60); 
        table.getColumnModel().getColumn(1).setPreferredWidth(250); 
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        
        int width = 500;
        //col.setPreferredWidth(width);
        //col.setMinWidth(10);
        col.setMaxWidth(width);
        
        
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        
        
    }
	
	
	
	//int row = table.getSelectedRow();
	//String valor =  TableFromMySqlDatabase.CONTENT_PANE_PROPERTY.getClass().getRecordComponents().toString();   
    //getValueAt(row, 1).toString(); 
	//System.out.println("Linha ..: "+ row);
    //System.out.println("Conteudo ..: "+valor );
    
    //System.out.println("Conteudo ..: ") ; 
    
    
    
/* 
    public static void main(String[] args)
    {
        TableFromMySqlDatabase frame = new TableFromMySqlDatabase();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(10,10,800,550); 
    }
    
    */ 
}