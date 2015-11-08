define(['angular', 'uiRouter','angularLocalStorage'], function(angular) {
    angular.module('loginControllers', ['restangular','ui.router', 'LocalStorageModule']).controller('LoginController', function($scope,$state,Restangular,localStorageService) {

        $scope.user = {};

        $scope.login = function() {
            //Restangular.all('/api/account/login').post($scope.user).then(function(jwt) {
            //    console.log("******************************");
            //    console.log(jwt);
            //    localStorageService.set('jwt', jwt);
            //    console.log("******************************");
            //    $state.go('master.list');
            //}, function(e) {
            //    console.log("error occurs" + e);
            //});

            $state.go('dashboard.service.list');
        }
    });
});