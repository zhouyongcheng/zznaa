define(['angular'], function(angular) {
    angular.module('masterServices', []).factory('masterService', function($http) {
        return {
            getCategories : function(category) {
                return $http.get('http://192.168.0.103:8080/api/categories', {
                    params : {
                        type : category
                    }
                });
            },
            getAllCategories : function() {
                console.log("calling getAllCategories method");
                return $http.get('http://192.168.0.103:8080/api/categories/all');
            }
        }
    });
});