define(['angular', 'uiRouter','angularLocalStorage'], function(angular) {
    angular.module('dashboardControllers', ['restangular','ui.router', 'LocalStorageModule'])
        .controller('DashboardController', function($scope,$state,Restangular,localStorageService) {
            $scope.message = 'this is dashboard page';
        });
});