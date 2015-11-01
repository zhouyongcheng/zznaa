define(['angular'], function(angular) {
    angular.module('buyingServices', []).factory('buyingService', function() {
        return {
            sayHello : function() {
                alert("hello");
            }
        }
    });
});