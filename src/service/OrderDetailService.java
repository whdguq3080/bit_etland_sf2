package service;

import java.util.List;

import domain.OrderDetailDTO;


public interface OrderDetailService {
	public void registOrderDetail(OrderDetailDTO ord);
	public List<OrderDetailDTO> bringOrderDetailList(); 
	public List<OrderDetailDTO> retrieveOrderDetail(String searchWord);
	public OrderDetailDTO retrieveOrderDetails(String searchWord);
	public int countOrderDetail();
	public boolean existsOrderDetail(String searchword);
	public void modifyOrderDetail(OrderDetailDTO ord);
	public void removeOrderDetail(OrderDetailDTO ord);
}
