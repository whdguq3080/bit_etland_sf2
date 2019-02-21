package enums;

public enum CustomerSQL {
	SIGNUP,SIGNIN, COUNT,LIST,ROW_COUNT,MEMBER,RETRIEVE_INFO,CUST_UPDATE, CUST_DELETE;
	
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
					+ "CITY,"
					+ "ADDRESS,"
					+ "POSTAL_CODE,"
					+ "PHOTO"
					+ ")"
					+" VALUES("
					+" ? , ? , ? , ? , ? , ? , ? , ?,'46')");
			break;
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS \n" +
					"WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;
		case LIST:
			query.append("SELECT T2.*\n" + 
					"FROM(SELECT ROWNUM R2,T.*\n" + 
					"        FROM (SELECT ROWNUM RNUM ,C.* \n" + 
					"        FROM CUSTOMERS C  \n" + 
					"        ORDER BY RNUM DESC) T) T2  \n" + 
					"WHERE R2 BETWEEN ? AND ? \n");

			break;
		case ROW_COUNT:
			query.append("SELECT COUNT(*) AS COUNT FROM CUSTOMERS");
			break;
		case MEMBER : 
			query.append("SELECT CUSTOMER_ID,CUSTOMER_NAME,PHONE\r\n" + 
					"FROM CUSTOMERS");
			break;
		case RETRIEVE_INFO : 
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
		case CUST_UPDATE :
			query.append("UPDATE CUSTOMERS\n" + 
						"SET phone = ?,city = ?,address=?,postal_Code =? ,password = ? \n" + 
						"WHERE CUSTOMER_ID = ?\n");
			break;
		case CUST_DELETE :
			query.append("DELETE \n" + 
					"FROM CUSTOMERS\n" + 
					"WHERE CUSTOMER_ID LIKE ? ");
			break;
		default:
			break;
		}
		return query.toString();
	}
	
}
