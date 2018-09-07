<html>
<head>
<meta charset="UTF-8">
<title>View page</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#filterInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#userTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>
</head>
<body>
	<h2> Users table </h2>
	There is two way of filtering: 1) making select query to db with using regex 2) jquery
	<form action="filter">
		<input type="text" name="reg">
		<input type="submit" value="Filter">
	</form>
	<input id="filterInput" type="text" placeholder="Search..">
	</form>
	<table>
		<thead>
			<th>Id</th>
			<th>Name</th>
		</thead>
		<tbody id="userTable">
		<#list users as user>
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
			</tr>
		</#list>
		</tbody>
	</table><br>
	<a href="back"> Back to the main page </a>
</body>
</html>