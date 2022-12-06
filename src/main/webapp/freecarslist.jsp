<%@ page contentType="text/html" pageEncoding="UTF-8" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Cars list" scope="application" />
<t:wrapper>

		<h1>Free cars</h1>
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
					<th>Price(day)</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Volkswagen</td>
					<td>Polo</td>
					<td>diesel</td>
					<td>mechanical</td>
					<td>2014</td>
					<td>Red</td>
					<td>Standart</td>
					<td>$25</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="requestform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>BMW</td>
					<td>M5 Compitition</td>
					<td>petrol</td>
					<td>Auto</td>
					<td>2020</td>
					<td>White</td>
					<td>Comfort</td>
					<td>$100</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="requestform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Lamborghini</td>
					<td>URUS</td>
					<td>petrol</td>
					<td>Auto</td>
					<td>2021</td>
					<td>Grey</td>
					<td>Premium</td>
					<td>$150</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="requestform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Tesla</td>
					<td>Model S</td>
					<td>electro</td>
					<td>Auto</td>
					<td>2021</td>
					<td>Black</td>
					<td>Premium</td>
					<td>$200</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="requestform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
				<tr>
					<td>Skoda</td>
					<td>Octavia</td>
					<td>petrol</td>
					<td>mechanical</td>
					<td>2018</td>
					<td>Brown</td>
					<td>Standart</td>
					<td>$35</td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="редактировать" href="requestform.jsp"><i class="material-icons">edit</i></a></td>
				</tr>
			</tbody>
		</table>

</t:wrapper>