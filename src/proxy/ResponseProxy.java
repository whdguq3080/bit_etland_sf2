package proxy;

import javax.servlet.http.HttpServletResponse;

import lombok.Data;

@Data
public class ResponseProxy implements Proxy  {

	private HttpServletResponse response;
	@Override
	public void carryOut(Object o) {
		System.out.println("ResponseProxy 접근");
		if((HttpServletResponse) o != null) {
		System.out.println("ResponseProxy o 가 널 임");
		setResponse((HttpServletResponse) o);
		}else {
		System.out.println("ResponseProxy o가 널 아님");
		}
	}

}
