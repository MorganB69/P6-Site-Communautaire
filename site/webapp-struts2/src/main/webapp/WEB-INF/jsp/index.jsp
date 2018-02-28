<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>



<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">



<head>
<title>Index</title>
<s:head />
</head>
<body>
	<s:include value="menu.jsp"></s:include>
	<s:include value="header.jsp"></s:include>
	
	<div class="container">
	
	<h2>Derniers spots</h2>
	
	
	<div class="row">
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#">
					<img class="card-img-top" src="http://placehold.it/700x400" alt="">
				</a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project One</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Amet numquam aspernatur eum quasi sapiente
						nesciunt? Voluptatibus sit, repellat sequi itaque deserunt,
						dolores in, nesciunt, illum tempora ex quae? Nihil, dolorem!</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#">
					<img class="card-img-top" src="http://placehold.it/700x400" alt="">
				</a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Two</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Nam viverra euismod odio, gravida pellentesque
						urna varius vitae.</p>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-sm-6 portfolio-item">
			<div class="card h-100">
				<a href="#">
					<img class="card-img-top" src="http://placehold.it/700x400" alt="">
				</a>
				<div class="card-body">
					<h4 class="card-title">
						<a href="#">Project Three</a>
					</h4>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Quos quisquam, error quod sed cumque, odio
						distinctio velit nostrum temporibus necessitatibus et facere atque
						iure perspiciatis mollitia recusandae vero vel quam!</p>
				</div>
			</div>
		</div>
	</div>

	

		<h2>Derniers Topos</h2>

		
		<div class="row">
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">Card Title</h4>
					<div class="card-body">
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Sapiente esse necessitatibus neque.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">Card Title</h4>
					<div class="card-body">
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Reiciendis ipsam eos, nam perspiciatis natus
							commodi similique totam consectetur praesentium molestiae atque
							exercitationem ut consequuntur, sed eveniet, magni nostrum sint
							fuga.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>
			<div class="col-lg-4 mb-4">
				<div class="card h-100">
					<h4 class="card-header">Card Title</h4>
					<div class="card-body">
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Sapiente esse necessitatibus neque.</p>
					</div>
					<div class="card-footer">
						<a href="#" class="btn btn-primary">Learn More</a>
					</div>
				</div>
			</div>

			</div>
			
			
			<s:form action="helloWorld">
				<s:textfield label="What is your name?" name="name" />
				<s:textfield label="What is the date?" name="dateNow" />
				<s:submit />

			</s:form>

			</div>
			
			
			<s:include value="footer.jsp"></s:include>
</body>

</html>
