<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" 
	href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">사원 등록</font>
 	</h1>
</div>
<div class="grid-item" id="content">
	<table id="cust_tab">
	  <tr>
	    <th>No.</th>
	    <th>회원이름</th>
	    <th>비밀번호</th>
	    <th>주소</th>
	    <th>도시</th>
	    <th>우편번호</th>
	    <th>주민번호</th>
	  </tr>
	  <tr>
	    <td>1</td>
	    <td>이종협</td>
	    <td>1234</td>
	    <td>파주시</td>
	    <td>경기도</td>
	    <td>111-111</td>
	    <td>900101-1</td>
	  </tr>
	  
	</table>
	<div style="height: 50px"></div>    
	<div class="center">
	  <div class="pagination">
	  <a href="#">&laquo;</a>
	  <a href="#" class="active">1</a>
	  <a href="#">2</a>
	  <a href="#">3</a>
	  <a href="#">4</a>
	  <a href="#">5</a>
	  <a href="#">&raquo;</a>
	  </div>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>