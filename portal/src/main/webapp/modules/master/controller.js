define(['angular', 'modules/master/service'], function(angular) {
    angular.module('masterControllers',['masterServices']).controller('MasterController', function($scope, masterService) {
        console.log("================step into MasterController======================");
        masterService.getAllCategories().success(function(data) {
            $scope.categories = data;
        }).error(function(data) {
            $scope.message = 'access error !';
        });
    });
});