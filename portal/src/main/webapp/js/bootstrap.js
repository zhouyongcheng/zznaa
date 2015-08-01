define(['app', 'angular','domReady'], function (app, angular, domReady) {
    domReady(function() {
        console.log('bootstrap is executed ............');
        angular.bootstrap(document, ['portal']);
    });
});