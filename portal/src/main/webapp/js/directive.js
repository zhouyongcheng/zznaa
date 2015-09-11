define(['angular'], function(angular) {
    var app = angular.module('AtmDirectives', []);

    app.directive('ngFileSelect', ['$rootScope', '$http', function ($rootScope, $http) {
        return function (scope, ele, attr) {
            ele.bind('change', function (e) {
                //上传
                //回调方法，本例为$scope中的upload()方法
                var fn = attr.ngFileSelect;
                var file = e.target.files[0];
                if (file == undefined) {
                    return false;
                }
                var form = new FormData();
                form.append('token', $rootScope.upload.token);//设置上传token
                form.append('file', file);
                $rootScope.loading = true;
                $http.post('http://localhost:8080/uploads', form, {
                    headers: {
                        'Content-Type': undefined//如果不设置Content-Type,默认为application/json,七牛会报错
                    }
                }).success(function (data) {
                    $rootScope.loading = false;
                    scope[fn]($rootScope.upload.cdn + data.key);//上传回调，将url传到upload方法中
                });
            });
        };
    }]);
});