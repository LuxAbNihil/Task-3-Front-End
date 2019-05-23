<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <title>Upload a video</title>
        <link rel="stylesheet" href="/videosharingsite/resources/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="navbar.jsp">
            <jsp:param name="Navigation Bar" value=""/>
        </jsp:include>
        <div class="form-container">
            <h1 class="text-center">Upload your Video Here!</h1>
            <form:form method="POST" modelAttribute="upload" enctype="multipart/form-data" class="form-horizontal">
                <div class="row">
                    <div class="form-group col-md-12">     
                        <div class="col-md-7">
                            <form:label class="col-md-5 control-label" path="video" for="file">Upload a Video!</form:label>
                            <form:input type="file" required="required" path="video" id="file" class="help-inline col-md-offest-6"/>
                        </div> <!-- End class "col-md-7 -->
                    </div> <!-- End class form-group -->
                </div> <!-- End class row -->

                <div class="row">
                    <div class="form-group col-md-12">
                        <form:label class="col-md-3 control-label" path="title" for="title">Title</form:label>
                        <form:input type="text" required="required" path="title" id="title" class="help-inline col-md-6"/>     
                     </div> <!-- End class form-group-->
                </div> <!-- End class row-->
                
                
                <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit" value="Upload" class="btn btn-primary btn-sm col-md-6 col-md-offset-3">
                        </div> <!-- End class form-actions -->
                </div> <!-- End class row -->
            </form:form>
        </div><!--End div for-container-->

    </body>
    
</html>