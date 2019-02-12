package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import enums.Action;
import proxy.Pagination;
import proxy.Proxy;
import service.CustomerServiceImpl;


public class ListCommand extends Command {
	//syso cmd=list&page=list&page_num=2&page_size=5
	public ListCommand(HttpServletRequest request,HttpServletResponse response) {
		super(request,response);
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())){
		case CUST_LIST:
			System.out.println(request.getParameter("cmd"));
			System.out.println(request.getParameter("page"));
			System.out.println(request.getParameter("page_num"));
			System.out.println(request.getParameter("page_size"));
		List<CustomerDTO> list = CustomerServiceImpl.getInstance().bringCustomerList(new Proxy().getPage());
		request.setAttribute("list", list);
		break;
		
		default:
		break;
	}
}
}
		
		//System.out.println("cmd=list&page=list&page_num=2&page_size=5");
