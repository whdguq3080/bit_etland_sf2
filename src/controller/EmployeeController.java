package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import domain.EmployeeDTO;
import enums.Action;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EmployeeService service = EmployeeServiceImpl.getInstance();   
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("======1.컨트롤러 진입 =======");
		Receiver.init(request,response);
		System.out.println("======2.컨트롤러 forward 직전 =======");
		Carrier.forword(request, response);
	}
}
