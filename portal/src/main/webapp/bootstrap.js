define(['app', 'angular','domReady'], function (app, angular, domReady) {
    domReady(function() {
        angular.bootstrap(document, ['bkoffice']);
    });
});