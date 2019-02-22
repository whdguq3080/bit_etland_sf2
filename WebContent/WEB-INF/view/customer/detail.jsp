<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${css}/customer/list.css"/>
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_bar">
<div class= "myphoto">
<div class= "myphotoin">
<form id="file_form">
	<img src="${img}/${image.imgName}.${image.imgExtention}" style="width:500px; height:500px;" ><br />
	<input type="file" name="file_upload" />
	<input type="submit" id="file_upload_btn" />
</form>
<div class="btn-group" role="group">
    <span id="photo_btn" class="label label-success">이미지 수정</span>
</div>
</div>
</div>
</div>
<form id="form" >
<div class="grid-item" id="content">
검색한 사람의 정보 <br />
아이디 ${cust.customerID} <br />
이 름 ${cust.customerName} <br />
생년월일 ${cust.ssn} <br />
성별 : 남 <br /> 
주소 : ${cust.city} <br />
상세주소 : ${cust.address}<br />
우편번호 : ${cust.postalCode}<br />
<div class="btn-group" role="group">
    <span id="update_btn" class="label label-warning">수정 </span>
    <span id="delete_btn" class="label label-danger">탈퇴</span>
</div>
</div>

</form>
<jsp:include page="../home/bottom.jsp"/>
</html>
<script>
$('#update_btn').click(function(){
		alert('수정 버튼 클릭');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customerID=${cust.customerID}');
});
$('#delete_btn').click(function(){
	alert('탈퇴가 완료 되었습니다.');
location.assign('${ctx}/customer.do?cmd=cust_delete&dir=home&page=main&customer_id=${cust.customerID}');
});
$('#file_upload_btn').attr('style','cursor:pointer').click(function(){
		$('#file_form')
		.attr('method','post')
		.attr('action','${ctx}/customer.do?cmd=cust_file_upload&page=detail&customer_id=${cust.customerID}')
		.attr('enctype','multipart/form-data')
		.submit();
});
</script>