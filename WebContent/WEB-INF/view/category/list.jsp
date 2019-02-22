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
<script>
 $('.page').click(()=>{
 		alert('--클릭한 페이지--'+$(this).text());
 location.assign('${ctx}/category.do?cmd=category_list&page=list&page_num='+$(this).text());
 });
 $('#cate_register').click(()=>{
	 $('#cate_side_menu>li').attr('style','background-color: white');
	 $('#cate_register').attr('style','background-color: #f2f7f9');
	 $('#content').html('<form id=form">'
			 +'  <div class="form-group">'
			 +'    <label for="text">CATEGORY NAME</label>'
			 +'    <input type="email" class="form-control" id="email">'
			 +'  </div>'
			 +'  <div class="form-group">'
			 +'    <label for="text">CONTENT</label>'
			 +'    <textarea row="4" cols="50" class="form-control" id="descrip"></textarea>'
			 +'  </div>'
			 +'  <button type="submit" class="btn btn-default">Submit</button>'
			 +'</form>');
 });
$('#cate_search').click(()=>{
	 $('#cate_side_menu>li').attr('style','background-color: white');
	 $('#cate_search').attr('style','background-color: #f2f7f9');
	 $('#content').html('<form id=form">'
			 +'  <div class="form-group">'
			 +'    <label for="text">CATEGORY SEARCH</label>'
			 +'     <select>'
			 +'   <option name="cate_id" value="1000">SMART PHONE</option>'
			 +'   <option name="cate_id" value="1001">NOTEBOOK</option>'
			 +'   <option name="cate_id  value="1002">DESKTOP</option>'
			 +'  </select>'
			 +'  <button type="submit" class="btn btn-default">Submit</button>'
			 +'</form>');
 });
$('#cate_delete').click(()=>{
		 $('#cate_side_menu>li').attr('style','background-color: white');
		 $('#cate_delete').attr('style','background-color: #f2f7f9');
		 $('#content').html('<form id=form">'
				 +'  <div class="form-group"><br />'
				 +'   <label for="text">CATEGORY DELETE</label><br />'
				 +'   <input type="checkbox" name="cate_id" value="1000">SMART PHONE</option><br />'
				 +'   <input type="checkbox" name="cate_id" value="1001">NOTEBOOK</option><br />'
				 +'   <input type="checkbox" name="cate_id  value="1002">DESKTOP</option><br />'
				 +'   <input type="submit"></button>'
				 +'</form>'); 
	 
 });
 $('#cate_update').click(()=>{
		 $('#cate_side_menu>li').attr('style','background-color: white');
		 $('#cate_update').attr('style','background-color: #f2f7f9');
		 $('#content').html('<form id=form">'
				 +'  <div class="form-group"><br />'
				 +'   <label for="text">CATEGORY UPDATE</label><br />'
				 +'   <input type="checkbox" name="cate_id" value="1000">SMART PHONE</option><br />'
				 +'   <input type="checkbox" name="cate_id" value="1001">NOTEBOOK</option><br />'
				 +'   <input type="checkbox" name="cate_id  value="1002">DESKTOP</option><br />'
				 +'   <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open</button>'
				 +'     <div class="modal fade" id="myModal" role="dialog">'
				 +'      <div class="modal-dialog">'
				 +'   		<div class="modal-content">'
				 +'          <div class="modal-header">'
				 +'            <button type="button" class="close" data-dismiss="modal">&times;</button>'
				 +'            <h4 class="modal-title">CATEGORY UPDATE</h4>'
				 +'          	<label for="text">CATEGORY NAME</label>'
				 +'   			 <input type="email" class="form-control" id="email">'
				 +'  			</div>'
				 +'   			 <label for="text">CONTENT</label>'
				 +'    			<textarea row="10" cols="100" class="form-control" id="descrip"></textarea>'
				 +'  			<button type="submit" class="btn btn-default">수정</button>'
				 +'  			</div>'
				 +' 			</div>'
				 +'          <div class="modal-body">'
				 +'             <p>Some text in the modal.</p>'
				 +'     </div>'
				 +'           <div class="modal-footer">'
				 +'            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>'
				 +'          </div>'
				 +'        </div>'
				 +'      </div>'
				 +'    </div>'
				 +'</form>'); 
 });
</script>
