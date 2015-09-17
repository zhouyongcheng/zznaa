define(['angular', 'modules/master/service'], function(angular) {angular.module('masterControllers', ['masterServices','restangular'])
    .controller('MasterController', function($scope, $state, Restangular, masterService) {
        $state.transitionTo('master.list');
    }).controller('MasterListController', function($scope, $state, Restangular, masterService) {

        masterService.getAllCategories().getList().then(function (data) {
            $scope.categories = data;
        });

        $scope.create = function() {
            $state.go("master.create");
        };

        $scope.update = function() {
            $state.go("master.update");
        };

        $scope.delete = function(ctype, ccode) {
            masterService.delCategory(ctype, ccode).remove().then(function(data){
                $state.transitionTo('master.list');
                console.log("success while delete category" + data);
            }, function(data) {
                console.log("error while delete category" + data);
            });
        };
    }).controller('MasterCreateController', function($scope,$state,masterService) {
        $scope.addCategory = function() {
            console.log("===================create category==========================")
            var category = $scope.category;
            masterService.addCategory(category).then(function(data) {
                console.log("success")
                $state.transitionTo("master.list");
            }, function(data) {
                console.log("failure");
            });
        }
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