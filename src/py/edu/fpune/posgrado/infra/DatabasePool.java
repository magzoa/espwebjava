package py.edu.fpune.posgrado.infra;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Singleton
 * Padrão de projeto utilizado para situações
 * onde só se pode ter uma única instância de uma classe
 */
public class DatabasePool {
	
	/**
	 * Atributo estático do mesmo tipo da classe
	 * Aqui vamos guardar a instância
	 */
	private static DatabasePool databasePool = null;
	
	private String userName;
	private String password;
	private String databaseName;
	private String driverClassName;
	private String url;
	private String host;
	private String port;
	
	private Connection connectionList[];
	private Boolean connectionStatus[];
	private Integer maxConnections;
	private Boolean testOnBorrow;
	private String sqlTest;
	private Integer intervalConnectionTime;
	private Integer maxConnectionTry;
	
	
	/**
	 * Construtor privado
	 */
	private DatabasePool() throws Exception {
		InputStream input = null;
		Properties prop = new Properties();
		try {
			input = new FileInputStream(this.getClass().getResource("/").getFile() + "../config.properties");
			prop.load(input);
			
			this.userName = prop.getProperty("userName");
			this.password = prop.getProperty("password");
			this.databaseName = prop.getProperty("databaseName");
			this.driverClassName = prop.getProperty("driverClassName");
			this.host = prop.getProperty("host");
			this.port = prop.getProperty("port");
			this.url = prop.getProperty("protocol") + "://" + this.host + ":" + this.port + "/" + this.databaseName;
			
			this.maxConnections = Integer.parseInt(prop.getProperty("maxConnections"));
			this.testOnBorrow = prop.getProperty("testOnBorrow").equals("true");
			this.sqlTest = prop.getProperty("sqlTest");
			this.intervalConnectionTime = Integer.parseInt(prop.getProperty("intervalConnectionTime"));
			this.maxConnectionTry = Integer.parseInt(prop.getProperty("maxConnectionTry"));
			
			this.initialize();			
			
		} catch (Exception e) {
			throw e;
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
	
	private void initialize() throws Exception {
		this.connectionList = new Connection[this.maxConnections];
		this.connectionStatus = new Boolean[this.maxConnections];
		Class.forName(this.driverClassName);
		for (int i = 0; i < this.maxConnections; i++) {
			this.connect(i);
		}
	}
	
	private void connect(Integer connectionId) throws Exception {
		this.connectionList[connectionId] = DriverManager.getConnection(this.url, this.userName, this.password);
		this.connectionList[connectionId].setAutoCommit(false);
		this.connectionStatus[connectionId] = true;
	}
	
	private void testConnection(Integer connectionId) throws Exception {
		Connection con = this.connectionList[connectionId];
		if (this.testOnBorrow) {
			if ((con == null) || (con.isClosed())) {
				this.connect(connectionId);
			} else {
				try {
					Statement stmt = con.createStatement();
					stmt.execute(this.sqlTest);
					stmt.close();
				} catch (SQLException e) {
					this.connect(connectionId);
				}
			}
		}
	}
	
	public Connection getConnection() throws Exception {
		Connection con = null;
		int count = 0;
		while ((con == null) && (count < this.maxConnectionTry)) {
			synchronized (DatabasePool.class) {
				for (int i = 0; i < this.connectionStatus.length; i++) {
					if (this.connectionStatus[i]) {
						this.testConnection(i);
						con = this.connectionList[i];
						this.connectionStatus[i] = false;
						break;
					}
				}
			}			
			if (con != null) {
				return con;	
			}
			count++;
			Thread.sleep(this.intervalConnectionTime);
		}
		throw new Exception("Não existem conexões disponíveis. Tente novamente.");
	}
	
	public void releaseConnection(Connection con) {
		for (int i = 0; i < this.connectionList.length; i++) {
			if (this.connectionList[i].equals(con)) {
				this.connectionStatus[i] = true;
				break;
			}
		}
	}
	
	/**
	 * Método público e estático para obter a instância
	 */
	public static synchronized DatabasePool getInstance() throws Exception {
		if (databasePool == null) {
			databasePool = new DatabasePool();
		}
		return databasePool;
	}
	
	
}
