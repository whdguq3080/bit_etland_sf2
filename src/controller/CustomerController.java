package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import domain.CustomerDTO;
import enums.Action;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@WebServlet("/customer.do")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerService service = CustomerServiceImpl.getInstance();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request,response);
		Carrier.forword(request, response);
		System.out.println("======");
	
	}
	}

