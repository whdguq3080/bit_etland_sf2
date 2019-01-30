package domain;
import lombok.Data;
public @Data class EmployeeDTO {
	private String employeesID,
					manager,
					name,
					birthDate,
					photo,
					notes;


}
