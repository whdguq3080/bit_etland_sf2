package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {
	public static Command order(HttpServletRequest request,HttpServletResponse response) {
		Command cmd = null;
		System.out.println("====3.커맨더진입=====");
		switch (Action
				.valueOf(request
				.getParameter("cmd")
				.toUpperCase())) {
		case MOVE:
			cmd = new Command(request,response);
			break;
		case REGISTER :
			cmd = new CreateCommand(request,response);
			break;
		case ACCESS : case SIGNIN :
			cmd = new ExistCommand(request,response);
			break;
		case SIGNUP :
			cmd = new CreateCommand(request,response);
			break;
		default:
			break;
		}
		System.out.println("커맨더 내부 : "+Receiver.cmd.getView());
		return cmd;
	}
	
}
