define(['angular',
        'controllers/controllers',
        'services/services',
        'directives/directives',
        'filters/filters'], function(angular) {
    return angular.module('portal',['controllers', 'services',
                                    'filters', 'directives']);
});
