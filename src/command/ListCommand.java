package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import proxy.PageProxy;
import proxy.Pagination;
import service.CustomerServiceImpl;


public class ListCommand extends Command {
	//syso cmd=list&page=list&page_num=2&page_size=5
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())){
		case CUST_LIST:
			System.out.println(request.getParameter("cmd"));
			System.out.println(request.getParameter("page"));
			System.out.println(request.getParameter("page_num"));
			System.out.println(request.getParameter("page_size"));
			Proxy paging = new Pagination();
			paging.carryOut(request);
			Proxy pagePxy= new PageProxy();
			pagePxy.carryOut(paging);
			List<CustomerDTO> list = CustomerServiceImpl.getInstance().bringCustomerList(pagePxy);
			request.setAttribute("list", list);
			request.setAttribute("pagination", paging);
			break;
			default:
			break;
	}
}
}
		
		//System.out.println("cmd=list&page=list&page_num=2&page_size=5");
