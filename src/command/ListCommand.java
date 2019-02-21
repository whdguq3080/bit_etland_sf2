package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ProductDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.ProPagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;


public class ListCommand extends Command {
	//syso cmd=list&page=list&page_num=2&page_size=5
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())){
		case CUST_LIST:
			Proxy paging = new Pagination();
			paging.carryOut(request);
			Proxy pagePxy= new PageProxy();
			pagePxy.carryOut(paging);
			List<CustomerDTO> list = CustomerServiceImpl.getInstance().bringCustomerList(pagePxy);
			request.setAttribute("list", list);
			request.setAttribute("pagination", paging);
			break;
		case PRODUCT_LIST:
			paging = new Pagination();
			paging.carryOut(request);
			pagePxy= new PageProxy();
			pagePxy.carryOut(paging);
			ProductDTO pro = new ProductDTO();
			pro.setProductsID(request.getParameter("PRODUCTS_ID"));
			List<ProductDTO> productlist = ProductServiceImpl.getInstance().bringProductList(pagePxy);
			request.setAttribute("list", productlist);
			request.setAttribute("pagination", paging);
			break;
			default:
			break;
	}
}
}
		
		//System.out.println("cmd=list&page=list&page_num=2&page_size=5");
