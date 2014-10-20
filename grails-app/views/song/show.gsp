
<%@ page import="org.elasticsearch.plugin.sample.Song" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'song.label', default: 'Song')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-song" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-song" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list song">
			
				<g:if test="${songInstance?.dateWritten}">
				<li class="fieldcontain">
					<span id="dateWritten-label" class="property-label"><g:message code="song.dateWritten.label" default="Date Written" /></span>
					
						<span class="property-value" aria-labelledby="dateWritten-label"><g:formatDate date="${songInstance?.dateWritten}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${songInstance?.locationPlayed}">
				<li class="fieldcontain">
					<span id="locationPlayed-label" class="property-label"><g:message code="song.locationPlayed.label" default="Location Played" /></span>
					
						<g:each in="${songInstance.locationPlayed}" var="l">
						<span class="property-value" aria-labelledby="locationPlayed-label"><g:link controller="location" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${songInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="song.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${songInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${songInstance?.writer}">
				<li class="fieldcontain">
					<span id="writer-label" class="property-label"><g:message code="song.writer.label" default="Writer" /></span>
					
						<span class="property-value" aria-labelledby="writer-label"><g:link controller="musician" action="show" id="${songInstance?.writer?.id}">${songInstance?.writer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:songInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${songInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
