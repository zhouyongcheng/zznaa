define(['jquery', 'angular', 'uiRouter','angularLocalStorage'], function($, angular) {

    angular.module('dashboardControllers', ['restangular','ui.router', 'LocalStorageModule'])
        .controller('DashboardController', function($scope,$state,Restangular,localStorageService) {
            $(function() {
                $('#menu').metisMenu();
                $('#menu2').metisMenu({
                    toggle: false
                });
                $('#menu3').metisMenu({
                    doubleTapToGo: true
                });
                $('#menu4').metisMenu();
            });
            $scope.message = 'this is dashboard page';
        });
});