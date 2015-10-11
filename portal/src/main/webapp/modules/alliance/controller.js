define(['angular'], function(angular) {
    angular.module('allianceControllers',[]).controller('AllianceController', function($scope) {
        $scope.province = "";
        $scope.city = "";
        $scope.area = "";

        $scope.address = {
            province : '',
            city : '',
            area : ''
        }

        $scope.showMessage = function() {
            console.log("province = " + $scope.province);
            console.log("city = " + $scope.city);
            console.log("area = " + $scope.area);

            console.log("address = " + $scope.address.province + ":" + $scope.address.city + ":" + $scope.address.area);
        }
    });
});