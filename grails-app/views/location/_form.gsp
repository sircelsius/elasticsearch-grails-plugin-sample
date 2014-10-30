<%@ page import="org.elasticsearch.plugin.sample.Location" %>



<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'lat', 'error')} required">
	<label for="lat">
		<g:message code="location.lat.label" default="Lat" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="lat" value="${fieldValue(bean: locationInstance, field: 'lat')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'lon', 'error')} required">
	<label for="lon">
		<g:message code="location.lon.label" default="Lon" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="lon" value="${fieldValue(bean: locationInstance, field: 'lon')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="location.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${locationInstance?.name}"/>

</div>

