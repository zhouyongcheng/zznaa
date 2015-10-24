define(['angular'], function(angular) {angular.module('vacationControllers', ['restangular'])
    .controller('VacationController', function($scope, $state, Restangular) {

        $scope.vacation = {};

        $scope.doApplyVacation = function() {
            Restangular.all('/api/vacation').post($scope.vacation).then(function() {
                console.log("apply vacation success");
            });
        };
    });
});