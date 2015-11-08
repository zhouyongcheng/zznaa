/**
 * Created by cmwin on 10/23/15.
 */
define(['angular', 'js/directive', 'modules/service/controller'], function(angular) {
    return angular.module('serviceModule', ['atm.directives','serviceControllers']);
});
