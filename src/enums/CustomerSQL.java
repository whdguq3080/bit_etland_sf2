package enums;

public enum CustomerSQL {
	SIGNUP,SIGNIN, COUNT,LIST;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,"
					+ "CUSTOMER_NAME,"
					+ "PASSWORD,"
					+ "SSN,"
					+ "PHONE,"
					+ "POSTALCODE,"
					+ "CITY,"
					+ "ADDRESS,"
					+ ")"
					+" VALUES("
					+" ? , ? , ? , ? , ? , ? , ? , ?)");
			break;
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS \n" +
					"WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;
		case LIST:
			query.append("SELECT T.*\n" + 
					"FROM (SELECT ROWNUM RNUM ,C.* \n" + 
					"        FROM CUSTOMERS C \n" + 
					"        ORDER BY ROWNUM DESC) T \n" + 
					"WHERE T.RNUM BETWEEN 27 AND 31 ");
			break;
		default:
			break;
		}
		return query.toString();
	}
	
}
