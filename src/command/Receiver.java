package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import domain.EmployeeDTO;

public class Receiver{
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request, 
			HttpServletResponse response) {
		EmployeeDTO emp = new EmployeeDTO();
		CustomerDTO cus = new CustomerDTO();
		cmd = Commander.order(request,response);
		System.out.println("====리시버 내부=====");
	}
}
