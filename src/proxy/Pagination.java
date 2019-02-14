package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy {
	private int pageNum,pageSize,blockSize,
		startRow,endRow,startPage,endPage,
		prevBlock,nextBlock,rowCount,totalCount;
	private boolean existPrev,existNext;
	@Override
	public void carryOut(Object o) {
		System.out.println("페이지네이션 내부 ");
		HttpServletRequest request = (HttpServletRequest)o; 
		String _pageNum = request.getParameter("page_num");
		pageNum =(_pageNum==null ) ? 1:(Integer.parseInt((_pageNum)));
		System.out.println("페이지 번호:" + pageNum);
		String _pageSize = request.getParameter("page_size");
		pageSize =(_pageSize==null ) ? 5:(Integer.parseInt((_pageSize)));
		System.out.println("페이지 사이즈:" + pageSize);
		String _blockSize = request.getParameter("block_size");
		blockSize =(_blockSize==null ) ? 5:(Integer.parseInt((_blockSize)));
		System.out.println("블록 사이즈:" + blockSize);
		rowCount = CustomerServiceImpl.getInstance().countCustomer(null);
		System.out.println("전체 카운트:" + rowCount);
		
		int pageCount = rowCount / pageSize;
		System.out.println("전체 페이지수: "+pageCount);
		startRow = (pageNum-1) *pageSize + 1;  //1
		System.out.println("스타트로우: "+startRow);
		endRow = (rowCount > pageNum * pageSize)? pageNum * pageSize: rowCount; //5
		System.out.println("엔드로우: "+endRow);

		startPage = (pageNum-1) *pageSize + 1; //1
		endPage   = (rowCount > pageNum * pageSize)? pageNum * pageSize: rowCount; //5
		
		existPrev = false;
		existNext = false;
		
		prevBlock = pageNum - pageSize; // 1- 5 = -4
		System.out.println("prevBlock="+prevBlock);
		nextBlock = startPage + pageSize; // 
		
		//blockSize = endRow - startRow;
		
		if(pageNum<=blockSize) {
			existPrev = true;
		}else {
			existPrev = false;
		}
		
	}
}
		






/*startRow = rowCount - ((pageSize * pageNum)-1);
		System.out.println("스타트로우" + startRow);
		endRow = startRow + (pageSize-1);
		System.out.println("엔드로우" + endRow);
		*/

