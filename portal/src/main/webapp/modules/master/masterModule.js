define(['angular',
        'modules/master/controller',
        'modules/master/service'], function(angular) {
    angular.module('masterModule', ['masterServices','masterControllers']);
});