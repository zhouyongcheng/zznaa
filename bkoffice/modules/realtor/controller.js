/**
 * Created by cmwin on 10/23/15.
 */
define(['angular', 'uiRouter','angularLocalStorage'], function(angular) {
    angular.module('realtorControllers', ['restangular','ui.router', 'LocalStorageModule'])
        .controller('RealtorController', function($scope) {
            $scope.message = '';
        })
        .controller('RealtorListController', function($scope,$state,Restangular,localStorageService,realtor) {
            $scope.realtor = realtor;

            $scope.edit = function(_id) {
                $state.go('realtor.edit', {id:_id});
            }

            $scope.delete = function(_id) {
                Restangular.one('/realtor',_id).remove().then(function() {
                    // delete from front side, avoid query database for new list
                    var r = _.find($scope.realtor, function(o) {
                        return o._id == _id;
                    });
                    var index = $scope.realtor.indexOf(r);
                    if (index > -1) {
                        $scope.realtor.splice(index, 1);
                    }
                });
            }

        }).controller('RealtorAddController', function($scope,$state,Restangular) {
            // 添加经纪人情报
            $scope.realtor = {
                province: '',
                city: '',
                distributor: ''
            };



        $scope.create = function() {
                $state.go('realtor.list');
            };

            $scope.back = function() {
                $state.go('realtor.list');
            }
        }).controller('RealtorEditController', function($scope,$state,Restangular,$stateParams) {

            console.log("realtor_id = " + $stateParams.id);

            Restangular.one("/realtor", $stateParams.id).get().then(function(realtor) {
                $scope.realtor = realtor;
            });

            $scope.save = function () {
                $scope.realtor.save().then(function(res) {
                    $scope.message = res.message;
                    $state.transitionTo('realtor.list');
                });
            };

            $scope.back = function() {
                $state.go('realtor.list');
            };
        });
});