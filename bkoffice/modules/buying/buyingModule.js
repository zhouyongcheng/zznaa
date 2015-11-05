define(['angular',
        'modules/buying/controller',
        'modules/buying/service'], function(angular) {
    angular.module('buyingModule', ['buyingControllers','buyingServices']);
});