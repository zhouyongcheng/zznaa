define(['angular',
    'uiRouter',
    'loginModule',
    'brokerModule'
], function(angular) {
    angular.module('bkoffice', ['ui.router', 'loginModule', 'brokerModule'])
        .config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider) {
            $stateProvider
                .state('login', {
                    url: '/login',
                    templateUrl: 'modules/login/login.html',
                    controller: 'LoginController'
                }).state('broker', {
                    url: '/broker',
                    templateUrl: 'modules/broker/broker.html',
                    controller: "BrokerController"
                });
            $urlRouterProvider.otherwise('/index');
        }]).controller('IndexController', function($scope) {
            $scope.message = "hello world";
        }).controller("SecondController",function ($scope) {
            $scope.message = "i like this game, but why?";
        });
});