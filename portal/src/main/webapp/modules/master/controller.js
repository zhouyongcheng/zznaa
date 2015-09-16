define(['angular', 'modules/master/service'], function(angular) {
    angular.module('masterControllers', ['masterServices','restangular']
    ).controller('MasterListController', function($scope, $state, Restangular, masterService) {
        masterService.getAllCategories().getList().then(function (data) {
           $scope.categories = data;
        });

        $state.go("master.list");

        $scope.create = function() {
            $state.go("master.create");
        };

        $scope.update = function() {
            console.log("calling update method--------------------------");
            $state.go("master.update");
        };

        $scope.delete = function() {
            console.log("calling delete method--------------------------");
            $state.go("master.list");
        };


    }).controller('MasterCreateController', function($scope) {
        $scope.category = {
            category : 'create',
            code : '1',
            label : 'Red',
            desc : 'Red Color',
            order : 1
        };
    }).controller('MasterUpdateController', function($scope) {
        $scope.category = {
            category : 'update',
            code : '1',
            label : 'Red',
            desc : 'Red Color',
            order : 1
        };

    });
});