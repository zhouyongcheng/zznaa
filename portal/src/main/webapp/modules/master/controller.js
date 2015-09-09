define(['angular', 'modules/master/service'], function(angular) {
    angular.module('masterControllers', ['masterServices']).controller('MasterController', function($scope, masterService) {
        console.log("--------------------");
        console.log(window.location.href);
        console.log("--------------------");

        masterService.getList().then(function (data) {
           $scope.categories = data;
        });

        masterService.one('sys_gender').get().then(function(data) {
            $scope.genders = data;
        })
    });
});