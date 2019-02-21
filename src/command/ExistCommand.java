package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import proxy.PageProxy;
import proxy.Pagination;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command  {
	
	public ExistCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		HttpSession session = request.getSession();
		switch (Action
				.valueOf(request
				.getParameter("cmd")
				.toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeesID(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exist = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if(exist) {
				System.out.println("사원 접근 허용 exist" + exist);
				Proxy paging = new Pagination();
				paging.carryOut(request);
				Proxy pagePxy = new PageProxy();
				pagePxy.carryOut(paging);
				List<CustomerDTO> list = CustomerServiceImpl.getInstance().bringCustomerList(pagePxy);
				request.setAttribute("list", list);
				System.out.println("액세스 접근허용");
				System.out.println("총 고객의 수:"+list.size());
				System.out.println("가장 최근에 가입한 고객명:" + list.get(0).getCustomerName());
				request.setAttribute("list", list);
				request.setAttribute("pagination", paging);
			}else {
				System.out.println("접근실패");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			
			break;
		case SIGNIN:
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerID(request.getParameter("CUSTOMER_ID"));
			cus.setPassword(request.getParameter("PASSWORD"));
			cus = CustomerServiceImpl.getInstance().retrieveCustomers(cus);
			if(cus != null) {
				System.out.println("로그인 성공");
				session.setAttribute("customer", cus);
				System.out.println("세션에 들어있는 이름"+((CustomerDTO)session.getAttribute("customer")).getCustomerName());
			}else {
				System.out.println("로그인 실패");
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
			}
				System.out.println("ExistCommand 내부:"+super.getView());
			break;
		
			default:
			break;
	}
}
}
