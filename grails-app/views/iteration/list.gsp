

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Iteration List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Iteration</g:link></span>
        </div>
        <div class="body">
            <h1>Iteration List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="description" title="Description" />
                        
                   	        <g:sortableColumn property="endDate" title="End Date" />
                        
                   	        <g:sortableColumn property="key" title="Key" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <th>Project</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${iterationInstanceList}" status="i" var="iterationInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${iterationInstance.id}">${fieldValue(bean:iterationInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:iterationInstance, field:'description')}</td>
                        
                            <td>${fieldValue(bean:iterationInstance, field:'endDate')}</td>
                        
                            <td>${fieldValue(bean:iterationInstance, field:'key')}</td>
                        
                            <td>${fieldValue(bean:iterationInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:iterationInstance, field:'project')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${iterationInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
