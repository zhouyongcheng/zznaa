require.config({
    paths : {
        jquery : 'bower_components/jquery/dist/jquery.min',
        twitter: 'bower_components/bootstrap/dist/js/bootstrap.min',
        angular : 'bower_components/angular/angular.min',
        uiBootstrap : 'bower_components/angular-bootstrap/ui-bootstrap.min',
        uiBootstrapTpls : 'bower_components/angular-bootstrap/ui-bootstrap-tpls.min',
        uiRouter : 'bower_components/angular-ui-router/release/angular-ui-router.min',
        restangular : 'bower_components/restangular/dist/restangular.min',
        angularJwt : 'bower_components/angular-jwt/dist/angular-jwt.min',
        angularLocalStorage : 'bower_components/angular-local-storage/dist/angular-local-storage.min',
        domReady : 'bower_components/requirejs-domready/domReady',
        lodash : 'bower_components/lodash/lodash.min',
        uiMask : 'bower_components/angular-ui-mask/dist/mask.min',
        uiEvent : 'bower_components/angular-ui-event/dist/event.min',
        loginModule : 'modules/login/loginModule',
        dashboardModule : 'modules/dashboard/dashboardModule',
        inboxModule : 'modules/inbox/inboxModule',
        vacationModule : 'modules/vacation/vacationModule',
        testModule : 'modules/test/testModule'
    },
    shim : {
        twitter : {
            deps: ['jquery']
        },
        angular : {
            deps : ['twitter'],
            exports : 'angular'
        },
        uiBootstrap : {
            deps : ['twitter','angular']
        },
        uiBootstrapTpls : {
           deps : ['uiBootstrap']
        },
        uiRouter : {
            deps : ['angular']
        },
        restangular : {
            deps : ['angular','lodash']
        },
        angularJwt : {
            deps : ['angular']
        },
        angularLocalStorage : {
            deps : ['angular']
        },
        uiMask : {
            deps : ['angular']
        },
        uiEvent : {
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
    domReady(function() {
        angular.bootstrap(document, ['atmbpm']);
    });
});