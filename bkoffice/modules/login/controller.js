define(['angular', 'uiRouter','angularLocalStorage'], function(angular) {
    angular.module('loginControllers', ['restangular','ui.router', 'LocalStorageModule'])
        .controller('LoginController', function($scope,$state,Restangular,localStorageService) {
            $scope.user = {};
            $scope.login = function() {
                Restangular.all('/signin').post($scope.user).then(function(data) {
                    //localStorageService.set('jwt', jwt);
                    $state.go('dashboard.customer');
                }, function(e) {
                    console.log("error occurs" + e);
                });
            };
        }).controller('ForgetController', function($scope,$state,Restangular,localStorageService) {

            $scope.message = '';

            // 获取验证码
            $scope.getVerifyCode = function() {
                Restangular.all('/sms/send').post($scope.user).then(
                    function(data) {
                        console.log(JSON.stringify(data));
                    },
                    function(e) {
                        console.log("error occurs" + e);
                    });
            };

            // 重置密码
            $scope.resetPassword = function() {
                Restangular.all('/password/reset').post($scope.user).then(
                    function(data) {
                        $scope.message = data.message;
                        console.log(JSON.stringify(data));
                    },
                    function(e) {
                        $scope.message = data.message;
                        console.log("error occurs" + e);
                    }
                );
            };
        });
    });