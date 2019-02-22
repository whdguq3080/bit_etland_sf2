package enums;

public enum CategorySQL {
	LIST,CATEGORY_COUNT;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {
		case LIST:
			query.append("SELECT T2.*\n" + 
					"FROM(SELECT ROWNUM R2,T.*\n" + 
					"FROM (SELECT ROWNUM RNUM ,P.* \n" + 
					"FROM CATEGORIES P \n" + 
					"ORDER BY RNUM DESC) T) T2 \n" + 
					"WHERE R2 BETWEEN ? AND  ?\n");
			break;
		case CATEGORY_COUNT:
			query.append("SELECT COUNT(*) COUNT FROM CATEGORIES");
			break;
		}
		return query.toString();
	}
}
