require.config({
    paths : {
        angular : 'bower_components/angular/angular.min',
        angularResource:'bower_components/angular-resource/angular-resource.min',
        uiRouter : 'bower_components/angular-ui-router/release/angular-ui-router.min',
        jquery : 'bower_components/jquery/dist/jquery.min',
        twitter: 'bower_components/bootstrap/dist/js/bootstrap.min',
        domReady : 'bower_components/requirejs-domready/domReady',
        loginModule : 'modules/login/loginModule',
        brokerModule : 'modules/broker/brokerModule',
        AdminLTE : 'js/app.min',
        Chart : 'bower_components/Chart.js/Chart.min'
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
        },
        angularResource : {
            deps : ['angular']
        },
        AdminLTE : {
            deps : ['jquery', 'twitter'],
            exports : '$.AdminLTE'
        }
    }
});

require(['angular',
         'app',
         'AdminLTE',
         'Chart'
], function(angular, app, Chart) {
    'use strict';
    var chartJs = Chart.noConflict();

});