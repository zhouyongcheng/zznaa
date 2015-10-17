define(['angular','angularLocalStorage'], function(angular) {
    angular.module('loginControllers', ['restangular','angular-jwt','LocalStorageModule'])
    .controller('LoginController', function($scope, $state,Restangular,localStorageService) {
        $scope.user = {};
        $scope.doLogin = function() {
            Restangular.all('/api/user/login').post($scope.user).then(function(jwt) {
                if (jwt) {
                    localStorageService.set('jwt', jwt);
                    $state.go('dashboard.inbox');
                }
            });
        };
    });
});