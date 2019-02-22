package proxy;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import lombok.Data;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;
import service.ProductServiceImpl;

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
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS: case CUST_LIST:
			rowCount = CustomerServiceImpl.getInstance().countCustomer(null);
			break;
		case PRODUCT_LIST:
			rowCount = ProductServiceImpl.getInstance().countProduct(null);
			break;
		case CATEGORY_LIST:
			rowCount = CategoryServiceImpl.getInstance().countCategorie(null);
			break;
		default:
			break;
		}
		System.out.println("전체 카운트:" + rowCount);
		
		startRow = (pageNum-1) *pageSize + 1;  //1..6...11...16...
		System.out.println("스타트로우: "+startRow);
		endRow = (rowCount > pageNum * pageSize)? pageNum * pageSize: rowCount; //5...10...15....20...
		System.out.println("엔드로우: "+endRow);
		
		startRow = (pageNum-1) * pageSize +1;
        endRow = (startRow + (pageSize-1) < rowCount)? startRow + (pageSize-1) : rowCount ;
        
        System.out.println("토탈::::::"+rowCount+"::::스타트::::"+startRow+":::엔드:::"+endRow);
        
        int blockNum = 0;
        blockNum = (pageNum-1)/blockSize;
        
        startPage = blockNum * blockSize +1;
        
        int pageCount = (int) Math.ceil(rowCount/(double)pageSize);
        System.out.println("pageCount@@@@"+pageCount);
        
        endPage = (pageCount < startPage + (blockSize-1))? pageCount : startPage + (blockSize-1) ;
        
        System.out.println("startPage@@@@"+startPage+"  endPage@@@@"+endPage);
        
        prevBlock = startPage - blockSize;
        nextBlock = startPage + blockSize;
        
        if(prevBlock < 0) {
            existPrev = false;
            existNext = true;
        }else{
            existPrev = true;
            existNext = false;
        }

		/*startPage = (pageNum-1) *pageSize + 1; //1,6,11,16....
		endPage   = (rowCount > pageNum * pageSize)? pageNum * pageSize: rowCount; //5,,10..15..20...
	
		if(pageNum <= 1*blockSize) {
			startPage = 1+0*blockSize;
		}else if(pageNum <= 2*blockSize) {
			startPage = 1+1*blockSize;
		}else if(pageNum <= 3*blockSize) {
			startPage = 1+2*blockSize;
		}
		prevBlock = startPage - pageSize; //-4...1...6...11...
		nextBlock = startPage + pageSize; //6...11...16...21...
		
		System.out.println("스타트페이지: "+startPage);
			if(startPage == 1) {
				endPage = 5;
			}else if(startPage == 6){
				endPage = pageCount;
			}
			System.out.println("엔드페이지: "+endPage);
			
			existPrev = (startPage - pageSize) > 0; //-4...1...6...11...>0
			existNext = (startPage + pageSize) <= pageCount; //6...11...16...21... <= 6
			prevBlock = startPage - pageSize; //-4...1...6...11...
			nextBlock = startPage + pageSize; //6...11...16...21...

			System.out.println("프리브블록: "+prevBlock);
			System.out.println("넥스트블록: "+nextBlock);*/
		
	}
}

