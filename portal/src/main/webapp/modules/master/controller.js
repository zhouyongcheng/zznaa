define(['angular', 'modules/master/service'], function(angular) {
    angular.module('masterControllers', ['masterServices','restangular']).controller('MasterController', function($scope, Restangular, masterService) {

        masterService.getAllCategories().getList().then(function (data) {
           $scope.categories = data;
        });
    });
});