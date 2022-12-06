<%@ page contentType="text/html" pageEncoding="UTF-8" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Cars list" scope="application" />
<t:wrapper>
		<h1>Busy cars</h1>
		<div class="row">
			<div class="col s12">
				<div class="center-align">
					<a class="btn-floating btn-large waves-effect waves-light" href="edit.jsp"><i class="material-icons">add</i></a>
				</div>
			</div>
		</div>
		<table>
			<thead>
				<tr>
					<th>Mark</th>
					<th>Model</th>
					<th>Fuel Type</th>
					<th>Transmission</th>
					<th>Year</th>
					<th>Color</th>
					<th>Class</th>
					<th>Tenant(surname)</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Volkswagen</td>
					<td>Golf R</td>
					<td>diesel</td>
					<td>Auto</td>
					<td>2017</td>
					<td>Blue</td>
					<td>Comfort</td>
					<td>Grib</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="registrationform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>MITSUBISHI</td>
					<td>LANCER</td>
					<td>petrol</td>
					<td>mechanical</td>
					<td>2017</td>
					<td>Red</td>
					<td>Comfort</td>
					<td>Karachun</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="registrationform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Mercedes</td>
					<td>AMG GT</td>
					<td>petrol</td>
					<td>Auto</td>
					<td>2021</td>
					<td>White</td>
					<td>Premium</td>
					<td>Usik</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="registrationform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Tesla</td>
					<td>Model X</td>
					<td>electro</td>
					<td>Auto</td>
					<td>2020</td>
					<td>White</td>
					<td>Premium</td>
					<td>Kunickiy</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="registrationform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Volvo</td>
					<td>XC90</td>
					<td>petrol</td>
					<td>mechanical</td>
					<td>2018</td>
					<td>Brown</td>
					<td>Standart</td>
					<td>Yakovec</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="registrationform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
			</tbody>
		</table>


</t:wrapper>