package domain;
import lombok.Data;
public @Data class OrderDetailDTO {
	private String orderdetailID,
				 	orderID,
				 	productsID,
				 	quantity;


}
