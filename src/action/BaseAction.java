package action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class BaseAction implements RequestAware,ApplicationAware,ServletRequestAware,SessionAware,ServletContextAware{
	//接受request对象
	protected Map<String,Object> request;
	//接受session对象
	protected Map<String,Object> session;
	//接受application对象
	protected Map<String,Object> application;
	//接受ServletRequest对象
	protected HttpServletRequest httpReq;
	//接受ServletContext对象
	protected ServletContext httpApplication;
	//该方法在创建Action对象时自动调用
	public void setServletContext(ServletContext sc) {
		this.httpApplication = sc;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest httpReq) {
		this.httpReq = httpReq;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;	
	}
}
