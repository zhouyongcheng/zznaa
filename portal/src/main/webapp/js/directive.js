define(['angular'], function(angular) {
    angular.module('atm.directives', [])
    .directive('atmTest', function() {
        return {
            restrict : 'AE',
            replace: true,
            templateUrl : 'js/template/test.html',
            link : function(scope, elem, attr) {
                elem.bind('mousemove', function() {
                    elem.css('cursor', 'pointer');
                });
            }
        };
    }).directive('atmLocation', function() {
        return {
            restrict : 'AE',
            replace : true,
            templateUrl : js/template/location.html,
            link : function(scope, elem, attr) {

            }
        };
   });
});