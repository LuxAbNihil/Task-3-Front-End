(function(){
    'use strict';

    angular
        .module('myApp')
        .controller('LoginController', LoginController);
    
    LoginController.$inject=['$log', '$scope', 'LoginService', 'UploadService', 'UserService'];

    function LoginController($log, $scope, LoginService, UploadService, UserService) {  
        let self = this;

        self.login={username:'',password:''};
        self.user={username:'',password:'',address:'',phoneNumber:'',email:'',age:null};
        self.responseList=[];
        self.uploadedVideos=[];
        self.users=[];  
    
        self.submit = submit;
        self.updateUser = updateUser;
        self.deleteUser = deleteUser;
        self.populateUserObject = populateUserObject;
        self.fetchAllUsers = fetchAllUsers;
        self.remove = remove;

        function submit() {
            if(self.login.username !== '' && self.login.password !== '') {
                $log.log('Submitting login request.');
                loginAction();
                self.login={username:'',password:''};
            } else if(self.user.username !== '') {         
                updateUser(self.user, self.user.username);
            } else {
                $log.log("Invalid data for submit");
            }
        }

        function loginAction() { //should I have self.loginAction = loginAction in this file?
            $log.log(self.login);
            LoginService.login(self.login)
            .then(
                function(response) {
                    self.responseSet = response.data;
                    $log.log("RESPONSE SET IS: ", self.responseSet);
                    self.users = self.responseSet.users;
                    self.uploadedVideos = self.responseSet.videos;
                    //setVisibility(document.getElementById("login-container"));
                },
                function(errResponse) {
                    $log.log('Error while loggin in');
                }
            );
        }

        function fetchAllUsers() {
            $log.log("In fetchAllUsers Function");
            UserService.fetchAllUsers()
                .then(
                    function(response) {
                        self.users = response.data;
                        $log.log("Self.users is: ", self.users);
                    },
                    function(errResponse) {
                        $log.log('Error while fetching users');
                    }
                )
        }

        function deleteUser(username) {
            UserService.deleteUser(username)
                .then (
                    function(response) {
                        fetchAllUsers();
                        $log.log('Deleting user');
                    },
                    function(errResponse) {
                        $log.log('Error deleting user');
                    }
                )
        }

        function populateUserObject(username) {
            $log.log("Element is: ", document.getElementById('edit-container'));
            setVisibility(document.getElementById('edit-container'));
            for(let i=0; i<self.users.length; i++) {
                if(self.users[i].username === username) {;
                    self.user = angular.copy(self.users[i]);
                }
            }
        }

        function remove(username) {
            $log.log('username to be deleted: ' + username);
          
            if(self.user.username === username) {
                reset();
            }
            deleteUser(username);
        } 

        function updateUser(user, username) {
            UserService.updateUser(user, username)
                .then (
                    function(response) {
                        fetchAllUsers();
                    },                   
                    function(errResponse) {
                        $log.log("Error updating user");
                    }
                );
        }

        function reset() {
            self.user={username:'',password:'',address:'',phoneNumber:'',email:'',age:null};
            $scope.myForm.$setPristine();
        }

        //Toggles visibility of divs
        function setVisibility(element) {
            $log.log("Element is in setVisibility ", element);
            if(element.style.display==="none") {
                element.style.display="block";
            } else {
                element.style.display="none"
            }
        }
    }
})();