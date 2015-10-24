define(['angular',
    'modules/master/service',
    'modules/master/controller'
    ], function(angular) {
    angular.module('masterModule', ['masterServices','masterControllers']);
});