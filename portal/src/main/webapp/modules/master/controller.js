define(['angular', 'modules/master/service'], function(angular) {angular.module('masterControllers', ['masterServices','restangular'])
    .controller('MasterController', function($scope, $state, Restangular, masterService) {

        $state.transitionTo('master.list');

    }).controller('MasterListController', function($scope, $state, Restangular, masterService) {

        Restangular.all("/api/categories").getList().then(function(data) {
            $scope.categories = data;
        });

        $scope.create = function() {
            $state.go("master.create");
        };

        $scope.update = function (ctype, ccode) {
            // pass parameter to the url belong to the master.update
            $state.go('master.update', {category:ctype, code:ccode});
        };

        $scope.delete = function(ctype, ccode) {
            $scope.categories.one(ctype, ccode).remove().then(function () {
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
    }).controller('MasterUpdateController', function($scope,$state, Restangular, $stateParams) {

        console.log("-----------------------------");
        console.log($stateParams.category);
        console.log("-----------------------------");

        var allCategories = Restangular.all('/api/categories');

        allCategories.one($stateParams.category, $stateParams.code).get().then(function (data) {
            $scope.category = data;
        });

        $scope.update = function() {
            $scope.category.save();
            $state.go('master.list');
        }
    });
});