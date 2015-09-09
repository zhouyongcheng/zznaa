define(['angular','restangular'], function(angular) {
    angular.module('masterServices', ['restangular']).factory('masterService', function(Restangular) {
        return Restangular.all('/api/categories');
    });
});