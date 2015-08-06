require.config({
    paths : {
        angular : 'bower_components/angular/angular',
        uiRouter : 'bower_components/angular-ui-router/release/angular-ui-router',
        jquery : 'bower_components/jquery/dist/jquery.min',
        twitter: 'bower_components/bootstrap/dist/js/bootstrap.min',
        domReady : 'bower_components/requirejs-domready/domReady',
        loginModule : 'modules/login/loginModule',
        brokerModule : 'modules/broker/brokerModule'
    },
    shim : {
        twitter : {
            deps: ['jquery']
        },
        angular : {
            deps : ['twitter'],
            exports : 'angular'
        },
        uiRouter : {
            deps : ['angular'],
            exports : 'uiRouter'
        }
    }
});

require(['angular',
    'bootstrap',
    'app'
], function(angular, app) {
    'use strict';
});