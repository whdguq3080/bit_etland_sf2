package service;

import java.util.List;

import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.ImageProxy;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService {
	private static ImageServiceImpl instance = new ImageServiceImpl();
	private ImageServiceImpl() {
		dao= ImageDAOImpl.getInstance();
		}
	public static ImageServiceImpl getInstance() {return instance;}
	ImageDAOImpl dao ;

	@Override
	public void addImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ImageDTO> imageList(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageDTO> searchImage(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countImage(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existImage(ImageDTO img) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeImage(ImageDTO img) {
		// TODO Auto-generated method stub
		
	}
	public void fileUpload(ImageDTO img) {
		dao.insertImage(img);
	}

}
