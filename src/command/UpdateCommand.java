package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand extends Command {
	public UpdateCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		String customerID = request.getParameter("customer_id");
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerID(customerID);
		cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
		System.out.println("수정하기전 회원의 정보 : " +cus.toString());
		if(!request.getParameter("city").equals(""))
			cus.setCity(request.getParameter("city"));
		if(!request.getParameter("address").equals(""))
			cus.setAddress(request.getParameter("address"));
		if(!request.getParameter("postalCode").equals(""))
			cus.setPostalCode(request.getParameter("postalCode"));
		if(!request.getParameter("password").equals(""))
			cus.setPassword(request.getParameter("password"));
		if(!request.getParameter("phone").equals(""))
			cus.setPhone(request.getParameter("phone"));
		CustomerServiceImpl.getInstance().modifyCustomer(cus);
		System.out.println("수정하려는 회원의 정보 : " +cus.toString());
		request.setAttribute("cust", cus);
	}
}
