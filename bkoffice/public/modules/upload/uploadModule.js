define(['angular', 'ngFileUpload', 'modules/upload/service','modules/upload/controller', 'modules/upload/directive'], function(angular) {
    angular.module('uploadModule',['uploadServices', 'uploadControllers','uploadDirectives']);
});