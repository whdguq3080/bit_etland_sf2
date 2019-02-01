package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.EmployeeDTO;
import service.EmployeeServiceImpl;
public class CreateCommand extends Command{
		public CreateCommand(HttpServletRequest request,HttpServletResponse response) {
		super(request,response);
		System.out.println("==Create 커맨드 진입==");
		EmployeeDTO emp = new EmployeeDTO();
		emp.setName(request.getParameter("name"));
		emp.setManager(request.getParameter("manager"));
		emp.setBirthDate(request.getParameter("birthday"));
		emp.setPhoto(request.getParameter("photo"));
		emp.setNotes(request.getParameter("notes"));
		EmployeeServiceImpl.getInstance().registEmployee(emp);
	}
}
