package dao;

import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
	private static OrderDetailDAOImpl instance = new OrderDetailDAOImpl();
	public OrderDetailDAOImpl() {}
	public static OrderDetailDAOImpl getInstance() {return instance;}


	@Override
	public void insertOrderDetail(OrderDetailDAO ord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetailDAO> selectOrderDetaillist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailDAO> selectOrderDetail(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDAO selectOrderDetails(String searchWord) {
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
	public void updateOrderDetail(OrderDetailDAO ord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderDetail(OrderDetailDAO ord) {
		// TODO Auto-generated method stub
		
	}

}
