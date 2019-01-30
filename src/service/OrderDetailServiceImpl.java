package service;

import java.util.List;

import dao.OrderDetailDAOImpl;
import domain.OrderDetailDTO;

public class OrderDetailServiceImpl implements OrderDetailService {
	private static OrderDetailServiceImpl Instance = new OrderDetailServiceImpl();
	public OrderDetailServiceImpl() {dao = OrderDetailDAOImpl.getInstance();}
	
	public static OrderDetailServiceImpl getInstance() {return Instance;}


	OrderDetailDAOImpl dao;

	@Override
	public void registOrderDetail(OrderDetailDTO ord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetailDTO> bringOrderDetailList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailDTO> retrieveOrderDetail(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailDTO retrieveOrderDetails(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrderDetail() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsOrderDetail(String searchword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyOrderDetail(OrderDetailDTO ord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrderDetail(OrderDetailDTO ord) {
		// TODO Auto-generated method stub
		
	}

}
