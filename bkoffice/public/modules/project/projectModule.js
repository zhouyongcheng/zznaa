define(['angular', 'uiRouter', 'modules/project/service', 'modules/project/controller'], function(angular) {
    angular.module('projectModule', ['ui.router','projectServices', 'projectControllers']);
});