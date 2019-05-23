(function(){
    'use strict'

    angular
        .module('myApp')
        .factory('UserService', UserService)
    
    UserService.$inject=['$log', '$http']

    function UserService($log, $http) {
        let REST_SERVICE_API='http://localhost:8081/videosharingsite';

        return {
           updateUser: updateUser,
           deleteUser: deleteUser,
           fetchAllUsers: fetchAllUsers,
           updateUser: updateUser
        };

        function fetchAllUsers() {
            return $http.get(REST_SERVICE_API + '/getAllUsers/');
        }

        function updateUser(user, username) {
            return $http.put(REST_SERVICE_API + '/updateUser/' + username, user );
        }

        function deleteUser(username) {
            return $http.delete(REST_SERVICE_API + '/deleteUser/' + username);
        }
    }
})();