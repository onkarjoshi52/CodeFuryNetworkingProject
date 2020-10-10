<%@ page language="java" import="java.util.List, com.demo.bean.*, java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Accept Request</title>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">

	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">

	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">

	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<%ArrayList<User> ulist=(ArrayList<User>)request.getAttribute("ulist"); %>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
					

					<div class="table100-body js-pscroll">
						

				<div class="table100 ver5 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Friend Requests</th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>	
							<form action="actionfriendrequest">						
		<%for(User user:ulist){ %>
          <tr class="row100 body">
          <td class="cell100 column1">
          <img src="data:image/jpg;base64,${user.uimage }" width="100" height="100"/>
          </td>
          <td class="cell100 column1">
          ${user.ufullname}
          </td>
          
          
            <td class="cell100 column1">
                <input type="hidden" name="senderUid" value="${user.id}" />
                <input type="submit" name="actionbutton" value="accept" />
	    	</td>
            <td class="cell100 column1">
	        <input type="submit" name="actionbutton" value="ignore" />
	    	</td>
	    	<td class="cell100 column1">
	        <input type="submit" name="actionbutton" value="block" />
	    	</td>
          </tr>
          <%} %>
</form>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>



	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>

	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<script src="vendor/select2/select2.min.js"></script>

	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})
		});
			
		
	</script>

	<script src="js/main.js"></script>

</body>
</html>