package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.ImageSQL;
import enums.Props;
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
		try {
			String sql = ImageSQL.INSERT_IMAGE.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, img.getImgName());
			ps.setString(2, img.getImgExtention());
			ps.setString(3, img.getOwner());
			int rs = ps.executeUpdate();
			if(rs==1) {
				System.out.println("성공");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ImageDTO selectImage(CustomerDTO cust) {
		ImageDTO image = new ImageDTO();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM IMAGE WHERE OWNER LIKE ?");
			ps.setString(1,cust.getCustomerID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			image.setImgSeq(rs.getString("IMG_SEQ"));
			image.setImgName(rs.getString("IMG_NAME"));
			image.setImgExtention(rs.getString("IMG_EXTENTION"));
			image.setOwner(rs.getString("OWNER"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
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
		String lastImage = "";
		CustomerDTO cus = new CustomerDTO();
		try {
			String sql = ImageSQL.LAST_IMAGE_SEQ.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lastImage = rs.getString("IMG_SEQ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastImage;
	}
}
