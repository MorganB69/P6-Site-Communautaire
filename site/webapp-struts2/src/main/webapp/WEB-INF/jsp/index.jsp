<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">



<head>
<title>Index</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<s:head />
</head>
<body>


	<header> 
		<s:include value="include/menu.jsp"></s:include> 
		<s:include value="include/carrousel.jsp"></s:include> 
	</header>

	<div class="container">

		<section class="row justify-content-center"> 
			<s:include value="lastsite.jsp"></s:include> 
		</section>

		<section class="row justify-content-center"> 
			<s:include value="lasttopo.jsp"></s:include> 
		</section>

		

	</div>

	<s:include value="include/footer.jsp"></s:include>




</body>

</html>
