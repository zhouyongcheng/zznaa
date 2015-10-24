define(['angular','angularLocalStorage'], function(angular) {
    angular.module('inboxControllers', ['restangular','angular-jwt','LocalStorageModule'])
    .controller('InboxController', function($scope, $state, tasks) {
            console.log("------------------inbox begin--------------------")
            $scope.tasks = tasks;
            console.log("------------------inbox begin--------------------")

    });
});