package com.crivero.arq.module.root.logging;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*
 * Datasource to connect log4j logger to the database
 */
public class ConnectionFactory {
	private static interface Singleton {
		final ConnectionFactory INSTANCE = new ConnectionFactory();
	}

	private boolean local = false;

	private static String hostname;
	private static String port;
	private static String username;
	private static String password;
	private String name;

	private DataSource dataSource;

	private void updateCredentials() {
		String vcap_services = System.getenv("VCAP_SERVICES");
		if (local) {
			// local machine
			hostname = "localhost";
			port = "3306";
			username = "root";
			password = "1234";
			name = "world";
		} else if (vcap_services != null && vcap_services.length() > 0) {
			// PCF ClearDB Service as Database
			JsonObject obj = (JsonObject) new JsonParser().parse(vcap_services);
			Entry<String, JsonElement> dbEntry = null;
			Set<Entry<String, JsonElement>> entries = obj.entrySet();

			for (Entry<String, JsonElement> eachEntry : entries) {
				if (eachEntry.getKey().equals("cleardb")) {
					dbEntry = eachEntry;
					break;
				}
			}
			if (dbEntry == null) {
				throw new RuntimeException("Could not find cleardb key in VCAP_SERVICES env variable");
			}
			obj = (JsonObject) ((JsonArray) dbEntry.getValue()).get(0);
			JsonObject credentials = (JsonObject) obj.get("credentials");
			hostname = credentials.get("hostname").getAsString();
			port = credentials.get("port").getAsString();
			username = credentials.get("username").getAsString();
			password = credentials.get("password").getAsString();
			name = credentials.get("name").getAsString();
		} else {
			// Docker MySQL image as Database
			hostname = "mysql";
			port = "3306";
			username = "root";
			password = "my-secret-pw";
			name = "my-mysql-db";
		}
	}

	private ConnectionFactory() {
		updateCredentials();
		this.dataSource = setupDataSource(
				"jdbc:mysql://" + hostname + ":" + port + "/" + name + "?useSSL=false&serverTimezone=UTC");
	}

	public static Connection getDatabaseConnection() throws SQLException {
		return Singleton.INSTANCE.dataSource.getConnection();
	}

	public static DataSource setupDataSource(String connectURI) {
		Properties properties = new Properties();
		properties.setProperty("user", username);
		properties.setProperty("password", password);
		DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory(connectURI, properties);
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
		ObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory);
		poolableConnectionFactory.setPool(connectionPool);
		PoolingDataSource<PoolableConnection> dataSource = new PoolingDataSource<>(connectionPool);

		return dataSource;
	}
}
