package domain;
import lombok.Data;
public @Data class ProductDTO {
	private String productsID,
					rnum,
					productName,
					supplierID,
					categoryID,
					unit,
					price;


}
