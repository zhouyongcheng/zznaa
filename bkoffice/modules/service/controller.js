/**
 * Created by cmwin on 10/23/15.
 */
define(['angular', 'uiRouter','angularLocalStorage'], function(angular) {
    angular.module('serviceControllers', ['restangular','ui.router', 'LocalStorageModule'])
        .controller('ServiceController', function($scope) {
            $scope.message = '';
        })
        .controller('ServiceListController', function($scope,$state,Restangular) {

            Restangular.one('/services').get().then(function(data){
                $scope.services = data.result;
            });


            $scope.edit = function(_id) {
                $state.go('service.edit', {id:_id});
            };

            $scope.delete = function(_id) {
                Restangular.one('/service',_id).remove().then(function() {
                    // delete from front side, avoid query database for new list
                    var r = _.find($scope.service, function(o) {
                        return o._id == _id;
                    });
                    var index = $scope.service.indexOf(r);
                    if (index > -1) {
                        $scope.service.splice(index, 1);
                    }
                });
            }

        }).controller('ServiceAddController', function($scope,$state,Restangular) {
            // 添加服务商情报
            $scope.service = {
                accesses : [
                    {code:'_PRIVATE', label:'私有'},
                    {code:'_PUBLIC', label:'公开'}
                ]
            };

            $scope.create = function() {
                console.log('----------step into create service method----------');
                Restangular.all('/service/create').post($scope.service).then(function(data) {
                    $state.go('dashboard.service.list');
                }, function(e) {
                    console.log("---------error occurs---------");
                    console.log(JSON.stringify(e));
                    console.log("---------error occurs---------");
                });
            };

            $scope.back = function() {
                $state.go('dashboard.service.list');
            }
        }).controller('ServiceEditController', function($scope,$state,Restangular,$stateParams) {

            console.log("service_id = " + $stateParams.id);

            Restangular.one("/service", $stateParams.id).get().then(function(service) {
                $scope.service = service;
            });

            $scope.save = function () {
                $scope.service.save().then(function(res) {
                    $scope.message = res.message;
                    $state.transitionTo('service.list');
                });
            };

            $scope.back = function() {
                $state.go('service.list');
            };
        });
});