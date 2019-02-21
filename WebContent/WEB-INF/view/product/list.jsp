<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" 
	href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">고객 목록</font>
 	</h1>
</div>
<div class="grid-item" id="content">
	<table id="pro_tab">
	  <tr>
	    <th>No.</th>
	    <th>아이디</th>
	    <th>제품명</th>
	    <th>공급처</th>
	    <th>카테고리</th>
	    <th>분류</th>
	    <th>가격</th>
	  </tr>
	  <c:forEach items="${list}" var="pro">
	  <tr>
	    <td>${pro.rnum}</td>
	    <td>${pro.productsID}</td>
	    <td>${pro.productName}</td>
	    <td>${pro.supplierID}</td>
	    <td>${pro.categoryID}</td>
	    <td>${pro.unit}</td>
	    <td>${pro.price}</td>
	  </tr>
	  </c:forEach>
	  
	</table>
	<div style="height: 50px"></div>    
	<div class="center">
	  <div class="pagination">
		<c:if test="${pagination.existPrev}">
		   <a href='${ctx}/product.do?cmd=product_list&page=list&page_num=${pagination.prevBlock}'>&laquo;</a>
		</c:if>
	 	<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" varStatus="status">
	 	 <c:choose>
	 		<c:when test="${pagination.pageNum eq status.index}"> 
	 	 	 <a href="#" class ='page active' >${status.index}</a>
	 		</c:when> 
	 	 	<c:otherwise> 	
	 		 <a href="#" class ='page' >${status.index}</a>
	 	  	</c:otherwise>
	 	 </c:choose>

	 	</c:forEach>
	 	<c:if test="${pagination.existNext}">
		  <a href='${ctx}/product.do?cmd=product_list&page=list&page_num=${pagination.nextBlock}'>&raquo;</a>
	 	</c:if>
	  </div>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
 $('.page').click(function(){
 		alert('--클릭한 페이지--'+$(this).text());
 		
 location.assign('${ctx}/product.do?cmd=product_list&page=list&page_num='+$(this).text());
 });
	//page_um,pageSize,
	//?cmd=list&page=list&page_num=2&page_size=5
	/*
 	 	<input type="hidden" name="cmd" value="access" />
	    <input type="hidden" name="dir" value="customer" />
	    <input type="hidden" name="page" value="list" />
	*/
	
</script>