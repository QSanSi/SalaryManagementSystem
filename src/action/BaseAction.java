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
	//����request����
	protected Map<String,Object> request;
	//����session����
	protected Map<String,Object> session;
	//����application����
	protected Map<String,Object> application;
	//����ServletRequest����
	protected HttpServletRequest httpReq;
	//����ServletContext����
	protected ServletContext httpApplication;
	//�÷����ڴ���Action����ʱ�Զ�����
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
