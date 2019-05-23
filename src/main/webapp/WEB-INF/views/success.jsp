<html>
    <head>
        <title>Upload Success</title>
        <link rel="stylesheet" href="/videosharingsite/resources/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="navbar.jsp">
            <jsp:param name="Navigation Bar" value=""/>
        </jsp:include>
        <div class="success">
            File <strong>${fileName}</strong> uploaded successfully.
        </div>
    </body>
</html>