define(['angular','restangular'], function(angular) {
    angular.module('masterServices', ['restangular']).factory('masterService', function(Restangular) {
        //return Restangular.all('/api/categories');
        var categories = Restangular.all('/api/categories');
        return {
            getAllCategories : function() {
                return categories;
            },
            getCategories : function(category) {
                return categories.getList(category);
            },
            getOptions : function(category) {
                return categories.one('option', category);
            },
            addCategory : function(category) {
                return categories.post(category);
            },
            delCategory : function(ctype, ccode) {
                return categories.one(ctype, ccode);
            }
        };
    });
});