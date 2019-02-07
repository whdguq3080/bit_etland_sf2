package enums;

public enum EmployeeSQL {
	REGISTER,ACCESS,COUNT;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case REGISTER:
			query.append("INSERT INTO EMPLOYEES(EMPLOYEE_ID,MANAGER,NAME,BIRTH_DATE,PHOTO,NOTES) "
					+ "VALUES("
					+ " EMP_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
			break;
		case ACCESS:
			query.append("SELECT NAME FROM EMPLOYEES \n" +
					"WHERE EMPLOYEE_ID LIKE ? AND NAME LIKE ?");
			break;
		default:
			break;
		}
		return query.toString();
	}
	
}
