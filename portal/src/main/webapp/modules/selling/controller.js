define(['angular','restangular'], function(angular) {
    angular.module('sellingControllers',['restangular']).controller('SellingController', function($scope, Restangular) {

        var location = Restangular.all('/api/location');

        $scope.province = "";
        $scope.city = "";
        $scope.area = "";
        $scope.provinces = location.all('provinces').getList().$object;

        $scope.changeProvince = function(province) {
            $scope.city = "";
            $scope.area = "";
            $scope.cities = location.all('cities/'+province).getList().$object;
        }

        $scope.changeCity = function(city) {
            $scope.area = "";
            $scope.areas = location.all('areas/'+city).getList().$object;
        }
        $scope.changeArea = function() {
            console.log($scope.province + ':' + $scope.city + ':' + $scope.area);
        }
    });
});