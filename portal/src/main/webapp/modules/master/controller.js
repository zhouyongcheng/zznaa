define(['angular', 'modules/master/service'], function(angular) {
    angular.module('masterControllers', ['masterServices']).controller('MasterController', function($scope, masterService) {
        //$scope.categories = [{code:'110',label:'man', note:'manxx'}];
        //$scope.message = "helloworld";
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