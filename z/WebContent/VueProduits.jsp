 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div>
		<form action="controleur.php" method="post">
		<table>
			<tr>
				<td>Mot Cle:</td>
				<td><input type="text" name="motCle" value="${model.motCle}"/></td>
				<td><input type="submit" value="Chercher"/></td>
		</table>
		</form>
	</div>
	<div>
		<table class="table1">
		<!-- am ramas aici: https://youtu.be/uQxMVXlqGzU?t=4906 -->
			<tr>
			<th>REF</th> <th>DES</th> <th>PRIX</th> <th>QUANTITE</th>
			</tr>
			<c:forEach items="${model.produits}" var="p">
				<tr>
					<td>${p.reference}</td>
					<td>${p.designation}</td>
					<td>${p.prix}</td>
					<td>${p.quantite}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>