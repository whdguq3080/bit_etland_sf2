package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeDTO;

public class Receiver{
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request, 
			HttpServletResponse response) {
		EmployeeDTO d = new EmployeeDTO();
		System.out.println("====2. 리시버 진입=====");
		cmd = Commander.order(request,response);
	}
}
