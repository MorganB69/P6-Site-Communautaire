<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<h2>Derniers Sites</h2>
		
		<div class='row'>
		<s:iterator value="listSite">
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card bg-light border-dark h-100" id="card-list">
				<s:a action="detail_site">
				<s:param name="id" value="id"></s:param>
					<img class="img-fluid card-img-top" id="img-card" src="image/site/<s:property value="image"/>" alt="">
				</s:a>
				<div class="card-body">
					<h4 class="card-title">
						<s:a action="detail_site">
						<s:param name="id" value="id"></s:param>
						<s:property value="nom" /></s:a>
					</h4>
					       
     							<ul>
						 			
						 		<s:if test="%{pays!=null}">
						 			<li><b>Pays : </b><s:property value="pays.name"/></li>
						 		</s:if>
						 		<s:if test="%{state!=null}">
           							<li><b>Région/Département :</b> <s:property value="state.name"/></li>
           				        </s:if>
           				        
           				         <s:if test="%{type!=null}">
										<b><li>Type de site :</b> <s:property value="type"/></li>
								</s:if>
								<li><b>Orientation :</b> 
									<s:iterator value="listeOrientation">
  											|<s:property value="orientation" />| 
									</s:iterator> 
									</li>
								</ul>
				</div>
			</div>
		</div>
		
		</s:iterator>
		
		</div>
</body>
</html>