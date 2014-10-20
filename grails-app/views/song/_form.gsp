<%@ page import="org.elasticsearch.plugin.sample.Song" %>



<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'dateWritten', 'error')} required">
	<label for="dateWritten">
		<g:message code="song.dateWritten.label" default="Date Written" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateWritten" precision="day"  value="${songInstance?.dateWritten}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'locationPlayed', 'error')} ">
	<label for="locationPlayed">
		<g:message code="song.locationPlayed.label" default="Location Played" />
		
	</label>
	<g:select name="locationPlayed" from="${org.elasticsearch.plugin.sample.Location.list()}" multiple="multiple" optionKey="id" size="5" value="${songInstance?.locationPlayed*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="song.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${songInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: songInstance, field: 'writer', 'error')} required">
	<label for="writer">
		<g:message code="song.writer.label" default="Writer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="writer" name="writer.id" from="${org.elasticsearch.plugin.sample.Musician.list()}" optionKey="id" required="" value="${songInstance?.writer?.id}" class="many-to-one"/>

</div>

