package dao;

import java.util.List;

public interface ShipperDAO {
	public void insertShipper(ShipperDAO cus);
	public List<ShipperDAO> selectShipperlist(); 
	public List<ShipperDAO> selectShipper(String searchWord);
	public ShipperDAO selectShippers(String searchWord);
	public int countShipper();
	public boolean existsShipper(String searchword);
	public void updateShipper(ShipperDAO cus);
	public void deleteShipper(ShipperDAO cus);
}
