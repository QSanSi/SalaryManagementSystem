package util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
//数据库类连接
public class DbUtil {
	private static DataSource ds;
	//创建线程局部变量，使Connection是一个线程安全的变量
	private static ThreadLocal <Connection>connLocal = new ThreadLocal<Connection>();
	static {
		try {
			//创建一个属性配置对象
			Properties prop = new Properties();
			//使用类加载器，去读取src底下的资源文件，对应文件位于src目录下
			InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
			//导入输入流
			prop.load(is);
			//读取属性
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//给ThreadLocal设置值
	public static Connection getConnection() throws Exception{
		Connection conn=connLocal.get();
		if(conn==null||conn.isClosed()){
			conn=ds.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}
	//销毁连接
	public static void closeConnection() throws Exception{
		Connection conn=connLocal.get();
		connLocal.set(null);
		if(conn!=null){
			conn.close();
		}
	}
	//实现数据库的事务，sql命令的提交由应用程序负责，程序必须调用commit或者rollback方法
	public static void startTransaction() throws Exception{
		Connection conn=getConnection();
		conn.setAutoCommit(false);
	}
	//commit方法
	public static void commit(){
		try {
			Connection conn=getConnection();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//rollback方法
	public static void rollback(){
		try {
			Connection conn=getConnection();
			conn.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		try {
			System.out.println(getConnection());
			System.out.println(getConnection().hashCode());
			System.out.println(getConnection().hashCode());
			System.out.println(getConnection().hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
