<html>
    <head>
        <title>Video Sharing Platform Login Page</title>
        <link rel="stylesheet" href="/videosharingsite/resources/bootstrap.min.css"/>
        <style>
            #edit-container {
                display: none;
                margin-left: 3em;
            }
            #hidden {
                display: none;
            }
        </style>
        <script>
            displayEdit = false;
        </script>
    </head>
    <body ng-app="myApp">
        <jsp:include page="navbar.jsp">
            <jsp:param name="Navigation Bar" value=""/>
        </jsp:include>
        <div ng-controller="LoginController as lc"> 
            <div class="form-container" ng-class="{'ng-hide': showLoginDiv}" id="login-container">
                <form ng-submit="lc.submit()" name="login Form">
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type=text required="required" class="form-control" id="username" ng-model="lc.login.username"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type=password require="required"class="form-control" id="password" ng-model="lc.login.password"/>
                    </div>
                    <div>
                        <button type="submit" ng-click="showLoginDiv = !showLoginDiv" class="btn btn-default">Submit</button>
                    </div>
                </form>
            </div> <!--End div login container-->
            
            <div class="form-container" id="edit-container">
                <form ng-submit="lc.submit()" name="editUser" class="form-horizontal">
                    <div class="form-group">
                        <label for="editPassword">Password:<label>
                        <input type="password" ng-model="lc.user.password" id="editPassword" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="editEmail">Email</label>
                        <input type="email" ng-model="lc.user.email" id="editEmail" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="editAddress">Address:<label>
                        <input type="text" ng-model="lc.user.address" id="editAddress" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="editPhoneNumber">Phone Number:<label>
                        <input type="text" ng-model="lc.user.phoneNumber" id="editPhoneNumber" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label edit="Age">Age:<label>
                        <input type="number" ng-model="lc.user.age" id="Age" class="form-control"/>
                    </div>
                    <div class="form-group" id="hidden">
                        <input type="text" ng-model="lc.user.id" id="id" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="submit"/>
                    </div>
                </form>
            </div><!--End div for-container-->
            
            <table>
                <tr ng-repeat="user in lc.users">
                    <td ng-bind="user.username"></td>
                    <td ng-bind="user.address"></td>
                    <td ng-bind="user.phoneNumber"></td>
                    <td><button ng-click="lc.populateUserObject(user.username)" class="btn">Edit</button></td>
                    <td><button ng-click="lc.deleteUser(user.username)" class="btn">Delete</button></td>
                </tr>
            </table>
            <div class="container">
                <div ng-repeat="upload in lc.uploadedVideos">
                    <div ng-bind="upload.title"></div>
                    <div ng-bind="upload.id"></div>
                    <div ng-bind="upload.video"></div>
                    <div><button ng-click="lc.editVideo()">Edit</div>
                    <div><button ng-click="lc.deleteVideo()">Delete</button></div>
                </div> <!-- ng-repeat-->
            </div><!--End div container-->
         </div><!--End div LoginController as lc-->
    
    </body>

    <script src="/videosharingsite/resources/angular.js"></script>
    <script src="/videosharingsite/resources/app.js"></script>
    <script src="/videosharingsite/resources/service/login_service.js"></script>
    <script src="/videosharingsite/resources/service/upload_service.js"></script>
    <script src="/videosharingsite/resources/service/user_service.js"></script>
    <script src="/videosharingsite/resources/controller/login_controller.js"></script>

</html>