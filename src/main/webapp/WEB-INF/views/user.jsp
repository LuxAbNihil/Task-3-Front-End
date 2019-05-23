<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <title>Video Sharing Website User Registration</title>
        <link rel="stylesheet" href="/videosharingsite/resources/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="navbar.jsp">
            <jsp:param name="Navigation Bar" value=""/>
        </jsp:include> 
        <h2>User Information</h2>
        <form:form method="POST" action="/videosharingsite/addUser/">
        
            <div class="form-group">
                <form:label path="username" >Username:</form:label>
                <form:input required="required" path="username" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="password" >Password:</form:label>
                <form:input required="required" type="password" path="password" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="address">Address:</form:label>
                <form:input path="address" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="phoneNumber">Phone Number:</form:label>
                <form:input path="phoneNumber" class="form-control"/>
            </div>
            <div class="form-group">
                <form:label path="age">Age:</form:label>
                <form:input path="age" class="form-control"/>
            </div>
            <div class="form-group">
                <input type="submit" value="submit"/>
            </div>
        </form:form>
    </body>
</html>