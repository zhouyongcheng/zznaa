define(['angular', 'modules/master/service'], function(angular) {angular.module('masterControllers', ['masterServices','restangular'])
    .controller('MasterController', function($scope, $state, Restangular, masterService) {

        $state.transitionTo('master.list');

    }).controller('MasterListController', function($scope, $state, Restangular, masterService) {

        $scope.categories = masterService.getAllCategories().getList().$object;

        $scope.create = function() {
            $state.go("master.create");
        };

        $scope.update = function() {
            $state.go("master.update");
        };

        $scope.delete = function(ctype, ccode) {
           masterService.findCategory(ctype, ccode).remove().then(function () {
               var r = _.find($scope.categories, function(o) {
                   return o.category == ctype && o.code == ccode;
               });
               var index = $scope.categories.indexOf(r);
               if (index > -1) {
                   $scope.categories.splice(index, 1);
               }
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