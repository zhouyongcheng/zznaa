/**
 * Created by cmwin on 10/23/15.
 */
define(['angular', 'uiRouter','angularLocalStorage'], function(angular) {
    angular.module('usersControllers', ['restangular','ui.router', 'LocalStorageModule'])
        .controller('UsersController', function($scope) {
            $scope.message = '';
        })
        .controller('UsersListController', function($scope,$state,Restangular,localStorageService,users) {
            $scope.users = users;

            $scope.edit = function(_id) {
                $state.go('users.edit', {id:_id});
            }

            $scope.delete = function(_id) {
                Restangular.one('/users',_id).remove().then(function() {
                    // delete from front side, avoid query database for new list
                    var r = _.find($scope.users, function(o) {
                        return o._id == _id;
                    });
                    var index = $scope.users.indexOf(r);
                    if (index > -1) {
                        $scope.users.splice(index, 1);
                    }
                });
            }

        }).controller('UsersAddController', function($scope,$state,Restangular) {
            $scope.user = {
                name : '',
                email : ''
            };
            $scope.addUser = function() {
                Restangular.all('/users').post($scope.user, function(user) {
                    console.log(user.name + ":" + user.email);
                });
                $state.go('users.list');
            };

            $scope.back = function() {
                $state.go('users.list');
            }
        }).controller('UsersEditController', function($scope,$state,Restangular,$stateParams) {

            console.log("user_id = " + $stateParams.id);

            Restangular.one("/users", $stateParams.id).get().then(function(user) {
                $scope.user = user;
            });

            $scope.save = function () {
                $scope.user.save().then(function(res) {
                    $scope.message = res.message;
                    $state.transitionTo('users.list');
                });
            };

            $scope.back = function() {
                $state.go('users.list');
            };
        });
});