require.config({

    paths : {
        jquery : 'bower_components/jquery/dist/jquery.min',
        twitter : 'bower_components/bootstrap/dist/js/bootstrap.min',
        angular : 'bower_components/angular/angular.min',
        ngResource : 'bower_components/angular-resource/angular-resource.min',
        uiRouter : 'bower_components/angular-ui-router/release/angular-ui-router.min',
        domReady : 'bower_components/domReady/domReady'
    },
    shim : {
        'twitter' : {
            deps : ['jquery']
        },
        'angular' : {
            deps : ['twitter'],
            exports : 'angular'
        },
        'ngResource' : {
            deps : ['angular']
        },
        'uiRouter' : {
            deps : ['angular']
        }
    }
});

require([
    'angular',
    'app',
    'domReady'
], function(angular,  app, domReady) {
    'use strict';
    app.value("API_POINT", 'http://localhost:8080/portal/api');

    domReady(function() {
        angular.bootstrap('document', ['portal']);
    });
});