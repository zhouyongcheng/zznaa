define(['angular', 'uiMask', 'uiEvent', 'uiBootstrap', 'uiBootstrapTpls'], function (angular) {
    angular.module('testControllers', ['ui.mask', 'ui.event','ui.bootstrap','ui.bootstrap.tpls','ui.bootstrap.collapse', 'restangular'])
        .controller('TestController', function ($scope, $timeout, Restangular) {
            $scope.person = {
                firstName: 'yongcheng',
                lastName: 'zhou',
                phone : ''
            };

            $scope.mobileMask = '999-99999999';

            $scope.getModel = function () {
                return JSON.stringify($scope.person, undefined, 2);
            };

            $scope.project = {
                open : true
            }

            var colors = ["#CCC", "#F77", "#9F9"];
            var activeColor = 0;
            $scope.modelStatus = function() {
                return { backgroundColor: colors[activeColor] };
            };
            $scope.focusCallback = function() {
                activeColor = 1;
            };
            $scope.blurCallback = function() {
                activeColor = 2;
                $timeout(function() { activeColor = 0; }, 2000);
            };

            // workflow img display area
            $scope.img = 'http://192.168.0.3:8080/api/workflow/diagram/11';
            Restangular.one("/api/workflow/diagram/coord", 11).get().then(function (data) {
                $scope.p = data;
                $scope.style = {
                    position: 'absolute',
                    border:'2px solid red',
                    top:data.y,
                    left:data.x,
                    width:data.width,
                    height:data.height
                }
            });


            // workflow img display area



        });
});