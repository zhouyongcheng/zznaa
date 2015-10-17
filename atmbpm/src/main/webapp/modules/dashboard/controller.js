define(['angular','angularLocalStorage'], function(angular) {
    angular.module('dashboardControllers', ['restangular','ui.router','LocalStorageModule'])
    .controller('DashboardController', function($scope, $state, Restangular, localStorageService) {
        $scope.logout = function() {
            localStorageService.remove('jwt');
            $state.go('login');
        }
    });
});