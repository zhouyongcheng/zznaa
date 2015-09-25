define(['angular','restangular'], function(angular) {
    angular.module('atm.directives', ['restangular'])
        .directive('atmTest', function () {
            return {
                restrict: 'AE',
                replace: true,
                templateUrl: 'js/template/test.html',
                scope: {},
                link: function (scope, elem, attr) {
                    elem.bind('mousemove', function () {
                        elem.css('cursor', 'pointer');
                    });
                }
            };
        }).directive('atmLocation', function (Restangular) {
            return {
                restrict: 'AE',
                replace: true,
                templateUrl: 'js/template/location.html',
                scope : {
                    province : '=',
                    city : '=',
                    area : '='
                },
                link : function(scope, elem, attr) {
                    var location = Restangular.all('/api/location');
                    scope.province = "";
                    scope.city = "";
                    scope.area = "";
                    scope.provinces = location.all('provinces').getList().$object;

                    scope.changeProvince = function(province) {
                        scope.city = "";
                        scope.area = "";
                        scope.cities = location.all('cities/'+province).getList().$object;
                    }
                    scope.changeCity = function(city) {
                        scope.area = "";
                        scope.areas = location.all('areas/'+city).getList().$object;
                    }
                }
            };
        });
})