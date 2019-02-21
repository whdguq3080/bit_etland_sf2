package enums;

public enum EmployeeSQL {
	REGISTER,ACCESS,COUNT,PRODUCT, PRODUCT_COUNT;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case REGISTER:
			query.append("INSERT INTO EMPLOYEES(EMPLOYEE_ID,MANAGER,NAME,BIRTH_DATE,PHOTO,NOTES) "
					+ "VALUES("
					+ " EMP_SEQ.NEXTVAL, ?, ?, ?, '46', ?)");
			break;
		case ACCESS:
			query.append("SELECT NAME FROM EMPLOYEES \n" +
					"WHERE EMPLOYEE_ID LIKE ? AND NAME LIKE ?");
			break;
		case PRODUCT:
			query.append("SELECT T2.*\n" + 
					"FROM(SELECT ROWNUM R2,T.*\n" + 
					"FROM (SELECT ROWNUM RNUM ,P.* \n" + 
					"FROM PRODUCTS P \n" + 
					"ORDER BY RNUM DESC) T) T2 \n" + 
					"WHERE R2 BETWEEN ? AND  ?\n");
			break;
		case PRODUCT_COUNT:
			query.append("SELECT COUNT(*) COUNT FROM PRODUCTS");
			break;
		default:
			break;
		}
		return query.toString();
	}
	
}
