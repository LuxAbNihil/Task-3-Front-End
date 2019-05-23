(function(){
    'use strict';

    angular
        .module('myApp')
        .factory('UploadService', UploadService);
    
    UploadService.$inject=['$log', '$http'] 

    function UploadService($log, $http) {
        let REST_SERVICE_API='http://localhost:8081/videosharingsite';
        
        return {
            editVideo: editVideo,
            deleteVideo: deleteVideo,
            getVideo: getVideo,
            getAllVideosForUser: getAllVideosForUser
        }

        function editVideo() {
            return $http.get(REST_SERVICE_API + "/updateVideo/");
        }

        function deleteVideo(id) {
            return $http.delete(REST_SERVICE_API + "/deleteVideo", id);
        }

        function getAllVideosForUser(username) {
            //Username is handled retrieved on the backend using HttpSession.getAttribute
            return $http.get(REST_SERVICE_API + "/getAllVideosForUser", username);
        }

        function getVideo(id) {
            return $http.get(REST_SERVICE_API + "/getVidoById", id);
        }
    }
})();