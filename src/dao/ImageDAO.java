package dao;

import java.util.List;

import domain.CustomerDTO;
import domain.ImageDTO;
import proxy.ImageProxy;
import proxy.Proxy;

public interface ImageDAO {
	public void insertImage(ImageDTO img);
	
	public ImageDTO selectImage(CustomerDTO cust);
	public String lastImageSeq();
	public List<ImageDTO> selectImages(Proxy pxy);
	public int countImage(Proxy pxy);
	public boolean existsImage(ImageDTO img);
	public void updateImage(ImageDTO img);
	public void deleteImage(ImageDTO img);
}
