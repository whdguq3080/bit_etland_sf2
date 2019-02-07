package enums;

public enum CustomerSQL {
	SIGNUP,SIGNIN;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS(CUSTOMER_ID,CUSTOMER_NAME,ADDRESS,CITY,POSTAL_CODE,PASSWORD,SSN)"
					+" VALUES("
					+" ? , ? , ? , ? , ? , ? , ? )");
			break;
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS \n" +
					"WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;
		default:
			break;
		}
		return query.toString();
	}
	
}
