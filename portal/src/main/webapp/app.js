define([
    'angular',
    'uiRouter',
    'restangular',
    'masterModule',
    'loginModule',
    'brokerModule',
    'buyingModule',
    'sellingModule',
    'repositoryModule',
    'allianceModule',
    'masterModule'
], function(angular) {
    return angular.module('portal', ['ui.router', 'masterModule', 'loginModule', 'brokerModule', 'buyingModule', 'sellingModule', 'repositoryModule', 'allianceModule'])
        .config(['$stateProvider', '$urlRouterProvider',function($stateProvider, $urlRouterProvider) {
            $stateProvider
                .state('master', {
                    url: '/master',
                    templateUrl: 'modules/master/master.html',
                    controller: 'MasterController'
                }).state('login', {
                    url: '/login',
                    templateUrl: 'modules/login/login.html'
                }).state('broker', {
                    url: '/broker',
                    templateUrl: 'modules/broker/broker.html'
                }).state('buying', {
                    url: '/buying',
                    templateUrl: 'modules/buying/buying.html',
                    controller: 'BuyingController'
                }).state('selling', {
                    url: '/selling',
                    templateUrl: 'modules/selling/selling.html'
                }).state('repository', {
                    url: '/repository',
                    templateUrl: 'modules/repository/repository.html'
                }).state('alliance', {
                    url: '/alliance',
                    templateUrl: 'modules/alliance/alliance.html'
                }).state('master', {
                    url: '/master',
                    templateUrl: 'modules/master/master.html',
                    controller: 'MasterController'
                });
            }]);
});