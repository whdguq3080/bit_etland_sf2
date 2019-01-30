package dao;

import java.util.List;

public interface OrderDetailDAO {
	public void insertOrderDetail(OrderDetailDAO ord);
	public List<OrderDetailDAO> selectOrderDetaillist(); 
	public List<OrderDetailDAO> selectOrderDetail(String searchWord);
	public CustomerDAO selectOrderDetails(String searchWord);
	public int countOrderDetail();
	public boolean existsOrderDetail(String searchword);
	public void updateOrderDetail(OrderDetailDAO ord);
	public void deleteOrderDetail(OrderDetailDAO ord);
}
