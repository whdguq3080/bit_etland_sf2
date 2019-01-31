package enums;

public enum EmployeeSQL {
	REGISTER,COUNT;
	
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case REGISTER:
			query = "INSERT INTO EMPLOYEES(EMPLOYEE_ID,MANAGER,NAME,BIRTH_DATE,PHOTO,NOTES) "
					+ "VALUES("
					+ " EMP_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
			break;
		case COUNT:
			
		default:
			break;
		}
		return query;
	}
	
}
