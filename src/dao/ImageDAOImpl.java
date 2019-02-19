package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.ImageDTO;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.ImageProxy;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO {
	private static ImageDAOImpl instance = new ImageDAOImpl();
	Connection conn;
	private ImageDAOImpl() {
		conn= DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();
	}
	public static ImageDAOImpl getInstance() {
		return instance;
	}
	@Override
	public void insertImage(ImageDTO img) {
		String sql = "";
		try {
			PreparedStatement ps = 
					DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection().prepareStatement(sql);
					 ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ImageDTO selectImage(ImageDTO img) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageDTO> selectImages(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countImage(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsImage(ImageDTO img) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String lastImageSeq() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
