<%@ page contentType="text/html" pageEncoding="UTF-8" %> 
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Cars list" scope="application" />
<t:wrapper>

		<h1>Registration</h1>
		<div class="row">
			<form class="col s12">
				<div class="row">
					<div class="input-field col s6">
					<i class="material-icons prefix">filter_1</i>
						<input id="first_name" type="text" class="validate"> <label for="first_name">First Name</label>
					</div>
					<div class="input-field col s6">
					<i class="material-icons prefix">filter_2</i>
						<input id="last_name" type="text" class="validate"> <label for="last_name">Last Name</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
					<i class="material-icons prefix">phone</i>
						<input id="phone_number" type="number" class="validate"> <label for="password">Phone number</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
					<i class="material-icons prefix">fiber_pin</i>
						<input id="password" type="password" class="validate"> <label for="password">Password</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
					<i class="material-icons prefix">email</i>
						<input id="email" type="email" class="validate"> 
						<label for="email">Email</label>
					</div>
				</div>
				<div class="row">
					<div class="col s12">
						Do you need help?
						<div class="input-field inline">
							<input id="email_inline" type="email" class="validate"> <label for="email_inline">Question</label> <span class="helper-text" data-error="wrong"
								data-success="right">Helper text</span>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="freecarslist.jsp"><i class="material-icons left">list</i>To the list</a> <a class="btn waves-effect waves-light green"
					href="#"><i class="material-icons left">save</i>Save</a>
			</div>
		</div>
</t:wrapper>