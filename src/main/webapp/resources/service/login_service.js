(function() {
    'use strict';

    angular
        .module('myApp')
        .factory('LoginService', LoginService);

    LoginService.$inject=['$log','$http'];

    function LoginService($log, $http) {
        let REST_SERVICE_API='http://localhost:8081/videosharingsite';

        return {
            login: login
        };

        function login(login) {
           return $http.post(REST_SERVICE_API + '/loginSubmit/', login);
        };

    }
})();