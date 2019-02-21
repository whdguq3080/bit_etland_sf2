<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp" />
<ul id="navi_bar">
	<jsp:include page="../category/nav.jsp" />
<link rel="stylesheet" href="${css}/employee/nav.css" />
		<div class="row" >
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<img data-src="holder.js/200%x200" alt="200%x200"
						src="${img}/smart.jpg" data-holder-rendered="true"
						style="height: 400px; width: 100%; display: block;">
					<div class="caption">
						<h3 id="thumbnail-label">
							SMARTPHONE<a class="anchorjs-link" href="#thumbnail-label"><span
								class="anchorjs-icon"></span></a>
						</h3>
						<p>GALAXY S10+</p>
					
						<p>improved hardware and faster wireless communication (due to standards such as LTE) 
						</p>
						<p>
							<a href="#" class="btn btn-primary" role="button">Button</a> <a
								href="#" class="btn btn-default" role="button">Button</a>
						</p>
					</div>
				</div>
			</div>
			<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img data-src="holder.js/200%x200" alt="200%x200"
					src="${img}/notebook.jpg" data-holder-rendered="true"
					style="height: 400px; width: 100%; display: block;">
				<div class="caption">
					<h3 id="thumbnail-label">
						NOTEBOOK<a class="anchorjs-link" href="#thumbnail-label"><span
							class="anchorjs-icon"></span></a>
					</h3>
					<p>9 Always</p>
					<p>A notebook (notepad, writing pad, drawing pad, legal pad)</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Button</a> <a
							href="#" class="btn btn-default" role="button">Button</a>
					</p>
				</div>
			</div>
		</div>
		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<img data-src="holder.js/200%x200" alt="200%x200"
					src="${img}/destop.jpg" data-holder-rendered="true"
					style="height: 400px; width: 100%; display: block;">
				<div class="caption">
					<h3 id="thumbnail-label">
						DESKTOP<a class="anchorjs-link" href="#thumbnail-label"><span
							class="anchorjs-icon"></span></a>
					</h3>
					<p>Odyssey</p>
					<p>he surface of a desk </p>
					<p>
						<a href="#" class="btn btn-primary" role="button">Button</a> <a
							href="#" class="btn btn-default" role="button">Button</a>
					</p>
				</div>
			</div>
			</div>
		</div>
	</div>
</ul>

<jsp:include page="../home/bottom.jsp" />
<script>
	$('#emp_register').click(function() {
		location.assign('employee.do?cmd=move&page=register');
	});
	$('#emp_access').click(function() {
		location.assign('employee.do?cmd=move&page=access');
	});
	$('#mypage').click(function() {
		alert('마이페이지 클릭');
		location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=detail&customerID=${customer.customerID}');
	});
</script>
