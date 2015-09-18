define(['angular','restangular'], function(angular) {
    angular.module('masterServices', ['restangular']).factory('masterService', function(Restangular) {

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
            findCategory : function(ctype, ccode) {
                return categories.one(ctype, ccode);
            }
        };
    });
});