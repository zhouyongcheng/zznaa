require.config({
    paths : {
        angular : 'bower_components/angular/angular.min',
        ngResource:'bower_components/angular-resource/angular-resource.min',
        uiRouter : 'bower_components/angular-ui-router/release/angular-ui-router.min',
        jquery : 'bower_components/jquery/dist/jquery.min',
        twitter: 'bower_components/bootstrap/dist/js/bootstrap.min',
        domReady : 'bower_components/requirejs-domready/domReady',
        lodash : 'bower_components/lodash/lodash.min',
        restangular : 'bower_components/restangular/dist/restangular.min',
        masterModule: 'modules/master/masterModule',
        loginModule : 'modules/login/loginModule',
        brokerModule : 'modules/broker/brokerModule',
        buyingModule : 'modules/buying/buyingModule',
        sellingModule : 'modules/selling/sellingModule',
        repositoryModule : 'modules/repository/repositoryModule',
        allianceModule : 'modules/alliance/allianceModule',
        masterModule : 'modules/master/masterModule',
        uploadModule : 'modules/upload/uploadModule',
        projectModule : 'modules/project/projectModule',
        ngFileUpload : 'bower_components/angular-file-upload/dist/angular-file-upload.min',
        fileUploadShim : 'bower_components/ng-file-upload/ng-file-upload-shim.min',
        fileUpload : 'bower_components/ng-file-upload/ng-file-upload.min'
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
            deps : ['angular']
        },
        ngResource : {
            deps : ['angular']
        },
        restangular : {
            deps : ['angular','lodash']
        },
        fileUpload : {
            deps : ['angular']
        },
        ngFileUpload : {
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
        angular.bootstrap(document, ['portal']);
    });
});