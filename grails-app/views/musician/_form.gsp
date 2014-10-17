<%@ page import="org.elasticsearch.plugin.sample.Musician" %>



<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'age', 'error')} required">
	<label for="age">
		<g:message code="musician.age.label" default="Age" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="age" required="" value="${musicianInstance?.age}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="musician.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${musicianInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: musicianInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="musician.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${musicianInstance?.lastName}"/>

</div>

