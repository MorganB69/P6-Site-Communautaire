<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<header> <%@ include file="../include/menu.jsp"%>  </header>

<div class="row justify-content-md-center">

<s:iterator value="listSite">

<div class="col-lg-4 col-sm-6 portfolio-item" >
			<div class="card bg-light border-dark h-100" id="card-list">
				<s:a action="detail_site">
				<s:param name="id" value="id"></s:param>
					<img class="card-img-top" src="image/site/<s:property value="image"/>" alt="">
				</s:a>
				<div class="card-body">
					<h4 class="card-title">
						<s:a action="detail_site">
						<s:param name="id" value="id"></s:param>
						<s:property value="nom" /></s:a>
					</h4>
					<p class="card-text"><s:property value="description"/></p>
				</div>
			</div>
		</div>
</s:iterator>  

</div>

<s:property value="lastPage"/>

<div class="row justify-content-md-center">
<nav aria-label="...">
	
  <ul class="pagination">
  
  <s:iterator status="incr" begin="1" end="%{lastPage}">  
    <li class="page-item">
       <s:a class="page-link" action="site_list">
						<s:param name="start" value="%{#incr.count}"></s:param>
						<s:property value="%{#incr.count}"/>
		</s:a>
    </li>
    
   </s:iterator >
   
  </ul>
</nav>

</div>

<footer> <%@ include file="../include/footer.jsp"%> </footer>
</body>
</html>