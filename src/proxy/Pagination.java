package proxy;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import enums.CustomerSQL;
import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Capable {
	private HttpServletRequest request; 
	private String pageNum,pageSize,blockSize,
		startRow,endRow,startPage,endPage,
		prewBlock,nextBlock;
	private int totalCount;
	private boolean existPrev,existNext;
	@Override
	public void carryOut() {
		

		
	}
}
