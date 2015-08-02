require.config({
    paths : {
        angular : 'bower_components/angular/angular.min',
        angularResource: 'bower_components/angular-resource/angular-resource.min',
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
        },
        angularResource : {
            deps : ['angular'],
            exports : 'angularResource'
        }
    }
});

require(['app',
         'bootstrap',
         'controllers/LoginController'
         ], function(angular, app) {
    'use strict';
});
