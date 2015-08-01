define(['controllers/controllers'], function(controllers) {
    controllers.controller('LoginController', ['$scope',function($scope) {
        $scope.user = {
            username : 'zhouyc',
            password : '123456'
        };
    }]);
});