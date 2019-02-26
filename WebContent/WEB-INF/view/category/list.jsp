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
 	<ul class= "list-group" id="cate_side_menu">
 	<li class="list-group-item" style="background-color: #f2f7f9"  id="cate_list">CATEGORY LIST </li>
 	<li class="list-group-item" id="cate_register" >CATEGORY REGISTER </li>
 	<li class="list-group-item" id="cate_search" >CATEGORY SEARCH </li>
 	<li class="list-group-item" id="cate_update" >CATEGORY UPDATE</li>
 	<li class="list-group-item" id="cate_delete" >CATEGORY DELETE </li>
 	</ul>
</div>

<div class="grid-item" id="content">
	<table id="pro_tab">
	  <tr>
	    <th>No.</th>
	    <th>카테고리 제목 </th>
	    <th>카테고리 설명</th>
	  </tr>
	  <c:forEach items="${list}" var="cat">
	  <tr>
	    <td>${cat.categoryId}</td>
	    <td>${cat.categoryName}</td>
	    <td> <a href="#">${cat.description}</a></td>
	  </tr>
	  </c:forEach>
	  
	</table>
	<div style="height: 50px"></div>    
	<div class="center">
	  <div class="pagination">
		<c:if test="${pagination.existPrev}">
		   <a href='${ctx}/category.do?cmd=category_list&page=list&page_num=${pagination.prevBlock}'>&laquo;</a>
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
		  <a href='${ctx}/category.do?cmd=category_list&page=list&page_num=${pagination.nextBlock}'>&raquo;</a>
	 	</c:if>
	  </div>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script src="${js}/employee.js">
 
</script>
