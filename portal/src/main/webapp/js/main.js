require.config({
    paths : {
        angular : 'bower_components/angular/angular.min',
        jquery : 'bower_components/jquery/dist/jquery.min',
        twitter: 'bower_components/bootstrap/dist/js/bootstrap.min',
        domReady : 'bower_components/requirejs-domready/domReady'
    },
    shim : {
        twitter : {
            deps: ['jquery']
        },
        angular : {
            deps : ['jquery','twitter'],
            exports : 'angular'
        }
    }
});

require(['app',
         'bootstrap',
         'controllers/LoginController'
         ], function(angular, app) {
    'use strict';
});
