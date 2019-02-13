package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class RequestProxy implements Proxy {
	private HttpServletRequest request;
	@Override
	public void carryOut(Object o) {
		System.out.println("-----3------");
		if((HttpServletRequest) o != null ) {
			System.out.println("RequestProxy o 가 널 임");
			setRequest((HttpServletRequest) o);
		}else {
		System.out.println("RequestProxy o 가 널 아님");
		}
	}
}
