<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" 
	href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id= "side_bar">
<div class= "myphoto">
<div class= "myphotoin"><img src="${img}/default_image.png" ></div>
</div>
</div>
<form id="form" >
<div class="grid-item" id="content">
검색한 사람의 정보 <br />
아이디 ${cust.customerID} <br />
이 름 ${cust.customerName} <br />
생년월일 ${cust.ssn} <br />
성별 : 남 <br /> 
주소 : 	<input type="text" name="city" placeholder="${cust.city}" /> <br />
상세주소 : <input type="text" name="address"   placeholder="${cust.address}" /> <br />
우편번호 : <input type="text" name="postalCode" placeholder="${cust.postalCode}"/> <br />
비밀번호 : ${cust.password} 
</div>
<div class="btn-group" role="group">
    <span id="update_btn" class="label label-warning">수정 </span>
</div>
<div class="btn-group" role="group">
    <span id="update_btn" class="label label-danger">탈퇴</span>
</div>
</form>
<jsp:include page="../home/bottom.jsp"/>
</html>
<script>
$('#update_btn').click(function(){
		alert('수정 버튼 클릭');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customerID=${cust.customerID}');
});
</script>