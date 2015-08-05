define(['angular',
        'angularResource',
        'controllers/controllers',
        'services/services',
        'directives/directives',
        'filters/filters'], function(angular) {
    return angular.module('portal',['ngResource','controllers', 'services',
                                    'filters', 'directives']);
});
