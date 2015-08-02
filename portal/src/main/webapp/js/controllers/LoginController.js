define(['controllers/controllers'], function(controllers) {
    controllers.controller('LoginController', ['$scope','$http',function($scope, $http) {
        $scope.user = {
            username : 'zhouyc',
            password : '123456',
            validate : function() {
                $http.get('http://192.168.0.103:8080/api/account/validate')
                    .success(function(data) {
                        console.log("success = " + data);
                    }).error(function(e) {
                        console.log("error : " + e.message);
                    });
            }
        };
    }]);
});