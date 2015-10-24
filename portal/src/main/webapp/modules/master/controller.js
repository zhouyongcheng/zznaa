define(['angular'], function(angular) {angular.module('masterControllers', ['restangular'])
    .controller('MasterController', function($scope, $state, Restangular) {
        // when move to master page, redirect to master.list
        $state.transitionTo('master.list');
    }).controller('MasterListController', function($scope, categories, $state, Restangular) {

        $scope.categories = categories;

        $scope.create = function() {
            $state.transitionTo("master.create");
        };

        $scope.update = function (ctype, ccode) {
            // pass parameter to the url belong to the master.update
            $state.transitionTo('master.update', {category:ctype, code:ccode});
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
    }).controller('MasterCreateController', function($scope,$state, Restangular) {
        $scope.addCategory = function() {
            Restangular.all('/api/categories').post($scope.category).then(function() {
                $state.transitionTo("master.list");
            });
        }
    }).controller('MasterUpdateController', function($scope, $state, Restangular, $stateParams) {
        var allCategories = Restangular.all('/api/categories');
        allCategories.one($stateParams.category, $stateParams.code).get().then(function (data) {
            $scope.category = data;
        });
        $scope.update = function() {
            $scope.category.save().then(function() {
                $state.transitionTo('master.list');
            });
        }
    });
});