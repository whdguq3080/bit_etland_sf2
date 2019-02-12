package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class Proxy implements Capable {
	private HttpServletRequest request; 
	private Pagination page;
	public Proxy() {carryOut();}
	@Override
	public void carryOut() {
		this.page = new Pagination();
		page.carryOut();
}
}