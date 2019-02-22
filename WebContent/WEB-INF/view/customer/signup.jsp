<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp" />
<link rel="stylesheet" href="${css}/employee/register.css" />
<div class="grid-item" id="side_menu">
<h1>회원 등록</h1>
</div>
<div class="grid-item" id="content">
<form id="form">
<div id="register-container">	
		<div class="input-group">

			<span class="input-group-addon" id="basic-addon1">아이디</span> <input
				type="text" id="customerID" name="customerID" class="form-control"
				placeholder="ID 입력" aria-describedby="basic-addon1" >
		</div><br />
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">회원 이름</span> <input
				type="text" id="customerName" name="customerName"
				class="form-control" placeholder="이름 입력"
				aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">비밀번호</span> <input
				type="text" id="password" name="password" class="form-control"
				placeholder="비밀번호 입력" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">주민번호</span> <input
				type="text" id="ssn" name="ssn" class="form-control"
				placeholder="주민번호 입력" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">전화번호</span> <input
				type="text" id="phone" name="phone" class="form-control"
				placeholder="전화번호를 입력하시오" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">주소</span> <input
				type="text" id="city" name="city" class="form-control"
				placeholder="주소를 입력하시오" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">상세주소</span> <input
				type="text" id="address" name="address" class="form-control"
				placeholder="상세주소를 입력하시오" aria-describedby="basic-addon1">
		</div><br />
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1">우편번호</span> <input
				type="text" id="postal_Code" name="postal_Code" class="form-control"
				placeholder="우편번호를 입력하시오" aria-describedby="basic-addon1">
		</div><br /><br />
		<div class="input-group">
			<button type="button" id="confirm_btn" class="btn btn-default btn-lg">
				<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
				확인
			</button>
			<button type="button" id="cancel_btn" class="btn btn-default btn-lg">
				<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
				취소
			</button>
		<input type="hidden" name="cmd" value="signup"/>
		<input type="hidden" name="page" value="signin"/>
</div>
</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"></jsp:include>
<script>
	$('#confirm_btn').click(function() {
	$('#form')
	.attr('action', '${ctx}/customer.do').submit();
		
	});
	
	$('#cancel_btn').click(function() {
			alert('취소버튼클릭!!');
		});
</script>
