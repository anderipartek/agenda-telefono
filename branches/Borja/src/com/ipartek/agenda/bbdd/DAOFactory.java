package com.ipartek.agenda.bbdd;

public abstract class DAOFactory {
	
	  // List of DAO types supported by the factory
	  public static final int MYSQL = 1;
	  //public static final int ORACLE = 2;
	  //public static final int SYBASE = 3;
	  
	  public static DAOFactory getDAOFactory(
		      int factorySelection) {
		   
		    switch (factorySelection) {
		 
		    	case MYSQL: 
		          return new MySqlDAOFactory();
		          /*
		      	case ORACLE    : 
		          return new OracleDAOFactory();      
		      	case SYBASE    : 
		          return new SybaseDAOFactory();
		      	...
		      	*/
		      	default           : 
		          return null;
		          
		    }
	  }
	  
	  public abstract DAOAmigo getDAOAmigo();
	

}
