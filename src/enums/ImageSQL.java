package enums;

public enum ImageSQL {
	LAST_IMAGE_SEQ,INSERT_IMAGE;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch(this) {
		case INSERT_IMAGE:
			query.append("INSERT INTO IMAGE(IMG_SEQ,IMG_NAME,IMG_EXTENTION,OWNER)\n" + 
					"VALUES(IMG_SEQ.NEXTVAL,?,?,?)");
			break;
		case LAST_IMAGE_SEQ:
			query.append(" SELECT IMG_SEQ \n" + 
					" FROM IMAGE  \n" + 
					" WHERE IMG_SEQ LIKE ((SELECT MAX(IMG_SEQ) \n" + 
					"                     FROM IMAGE))");
			break;
		}
		return query.toString();
	}
}
