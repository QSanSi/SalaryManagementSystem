package action.user;

import util.Factory;
import com.opensymphony.xwork2.ActionContext;
import action.BaseAction;
import dao.UserDao;
import entity.User;

public class LoginAction extends BaseAction {
	private String username;
	private String password;
	private User user;

	public String execute() throws Exception {
		UserDao userDao = (UserDao) Factory.getInstance("UserDao");
		user = userDao.findByUsername(username);
		if (user == null) {
			request.put("username_error", "用户名不存在");
			return "username_error";
		} else if (!user.getPassword().equals(password)) {
			request.put("password_error", "用户名密码错误");
			return "password_error";
		} else {
			session.put("userInfo", user.getUsername());
			ActionContext.getContext().getSession().put("userdept", user.getDept());
			if(user.getRights().equals("super"))
				return "success";
			else if(user.getRights().equals("emp"))
				return "success_emp";
			else if(user.getRights().equals("salary"))
				return "success_salary";
			else if(user.getRights().equals("attendence")) {
				return "success_attendence";				
			}else {
				return "username_error";
			}
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
