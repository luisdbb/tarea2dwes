package com.dawes.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.dawes.dao.*;
import com.dawes.daoImpl.*;
import com.mysql.cj.jdbc.MysqlDataSource;

public class MySqlDAOFactory {

	private Connection con;

	private static MySqlDAOFactory f;

	// el patron factory realiza la conexi�n
	private MySqlDAOFactory() {
		Properties prop = new Properties();
		MysqlDataSource m = new MysqlDataSource();
		FileInputStream fis;

		// Abrimos un canal de lectura al fichero de texto plano
		try {
			fis = new FileInputStream("src/main/resources/db.properties");

			// cargamos la informacion del fichero properties
			prop.load(fis);

			// asignamos al origen de datos las propiedades leidas del fichero properties
			m.setUrl(prop.getProperty("url"));
			m.setPassword(prop.getProperty("password"));
			m.setUser(prop.getProperty("usuario"));

			// obtengo la conexion
			con = m.getConnection();


		} catch (FileNotFoundException e) {
			System.out.println("Error al acceder al fichero properties " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error al leer las propiedades del fichero properties" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error al conectar a la base de datos:usuario,password....");
		}
	}

	// El patron factory proporciona metodos que devuelven los objetos complejos
	// donde inyecta la conexi�n
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl(con);
	}
	
	public EjemplarDAO getEjemplarDAO() {
		return new EjemplarDAOImpl(con);
	}
	
	public LocalizacionDAO getLocalizacionDAO() {
		return new LocalizacionDAOImpl(con);
	}
	
	public PlantaDAO getPlantaDAO() {
		return new PlantaDAOImpl(con);
	}
	
	public ParcelaDAO getParcelaDAO() {
		return new ParcelaDAOImpl(con);
	}
	
	
	
	

	public static MySqlDAOFactory getCon() {
		if (f==null)
			f=new MySqlDAOFactory();
		return f;
	}
}
