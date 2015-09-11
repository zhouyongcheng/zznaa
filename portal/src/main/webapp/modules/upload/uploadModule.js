define(['angular','ngUploadcare', 'modules/upload/service','modules/upload/controller'], function(angular) {
    angular.module('uploadModule',['uploadServices', 'uploadControllers','ng-uploadcare']);
});