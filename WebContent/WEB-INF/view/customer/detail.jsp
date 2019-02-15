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
<div class= "myphotoin"><img src="http://image.chosun.com/sitedata/image/201810/04/2018100400992_0.jpg"  style="height: 100px; width: 250px; "></div>
</div>
</div>
<body> 

검색한 사람의 정보 <br />
아이디 ${cust.customerID} <br />
이 름 ${cust.customerName} <br />
생년월일 ${cust.ssn} <br />
성별 : 남 <br /> 
전화번호 : ${cust.phone} <br /> 
우편번호 : ${cust.postalCode} <br />
주소 : ${cust.city} <br />
상세주소 : ${cust.address} 

</body>
</html>