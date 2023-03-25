package util;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
//���ݿ�������
public class DbUtil {
	private static DataSource ds;
	//�����ֲ߳̾�������ʹConnection��һ���̰߳�ȫ�ı���
	private static ThreadLocal <Connection>connLocal = new ThreadLocal<Connection>();
	static {
		try {
			//����һ���������ö���
			Properties prop = new Properties();
			//ʹ�����������ȥ��ȡsrc���µ���Դ�ļ�����Ӧ�ļ�λ��srcĿ¼��
			InputStream is = DbUtil.class.getClassLoader().getResourceAsStream("db.properties");
			//����������
			prop.load(is);
			//��ȡ����
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//��ThreadLocal����ֵ
	public static Connection getConnection() throws Exception{
		Connection conn=connLocal.get();
		if(conn==null||conn.isClosed()){
			conn=ds.getConnection();
			connLocal.set(conn);
		}
		return conn;
	}
	//��������
	public static void closeConnection() throws Exception{
		Connection conn=connLocal.get();
		connLocal.set(null);
		if(conn!=null){
			conn.close();
		}
	}
	//ʵ�����ݿ������sql������ύ��Ӧ�ó����𣬳���������commit����rollback����
	public static void startTransaction() throws Exception{
		Connection conn=getConnection();
		conn.setAutoCommit(false);
	}
	//commit����
	public static void commit(){
		try {
			Connection conn=getConnection();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//rollback����
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
