angular.module("formApp", ['ui.router']).config(function($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('view1', {
            url: '/view1',
            templateUrl: 'view1.html'
        }).state('view2', {
            url: '/view2',
            templateUrl: 'view2.html'
        });

    $urlRouterProvider.otherwise('/view1');

});