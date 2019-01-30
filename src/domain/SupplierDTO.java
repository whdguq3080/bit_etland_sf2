package domain;
import lombok.Data;
public @Data class SupplierDTO {
	private String supplierID,
					supplierNAME,
					address,
					city,
					postalcode,
					phone;
					
}
