define(['angular'], function(angular) {
    angular.module('buyingControllers',[]).controller('BuyingController', function($scope) {
        $scope.user = {
            username : 'zhouyc',
            address : 'dalian'
        }
    });
});