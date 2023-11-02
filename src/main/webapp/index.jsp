<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.Random" %>
<%!
public String randomId(){
	return "ENSA-" + (int) (Math.random() * 1000);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des etudiant</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body style="background-color:#F7EFE5;">

<div style="border:1 solid black; margin-left:20%; margin-top:80px; width:60%;">

<form method="post" action="index" style="background-color:#D8D9DA;padding:30px;">
	<h2><c:out value="Gestion des Etudiant"></c:out></h2>
	<br>
	<hr>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Code :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" value="<%= randomId()%>" name="code">
    </div>
  </div>
 
	<hr>
  <div class="form-group row">
    <label for="nom" class="col-sm-2 col-form-label">Nom :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="nom" >
    </div>
    <hr>
  </div><div class="form-group row">
    <label for="Prenom" class="col-sm-2 col-form-label">Prenom :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="prenom" >
    </div>
  </div>
	<hr>
  <div class="form-group row">
    <label for="Age" class="col-sm-2 col-form-label">Age :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="age" >
    </div>
  </div>
 
	<hr>
	<div class="form-group row">
    <label for="Ville" class="col-sm-2 col-form-label">Ville :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="ville" >
    </div>
  </div>
  <hr>
 <button type="submit" class="btn btn-danger">valider</button>
	<hr>
  
</form>

<table style="margin-top:30px;background-color:#D8D9DA;padding:30px;width:60%;">
  <thead style="background-color:#ffffff;;">
    <tr>
      <th>Code</th>
      <th>Nom</th>
      <th>Prénom</th>
      <th>Age</th>
      <th>ville</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${listeEtudiants}" var="etudiant">
      <tr>
        <td><c:out value="${etudiant.code}" /></td>
        <td><c:out value="${etudiant.nom}" /></td>
        <td><c:out value="${etudiant.prenom}" /></td>
        <td><c:out value="${etudiant.age}" /></td>
         <td><c:out value="${etudiant.ville}" /></td>
        <td><a href="index?id=<c:out value='${etudiant.code}' />"><i class="fa-solid fa-trash-can" style="color: #ea1a1a;"></i></a></td>
      </tr>
    </c:forEach>
  </tbody>
</table>

  

</body>
</html>