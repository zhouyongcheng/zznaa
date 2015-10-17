define([
    'angular',
    'uiRouter',
    'restangular',
    'uiBootstrap',
    'uiBootstrapTpls',
    'angularJwt',
    'angularLocalStorage',
    'uiMask',
    'uiEvent',
    'loginModule',
    'dashboardModule',
    'vacationModule',
    'inboxModule',
    'testModule'
], function(angular) {
    return angular.module('atmbpm',
        ['ui.router',
         'restangular',
         'ui.bootstrap',
         'ui.bootstrap.tpls',
         'ui.bootstrap.collapse',
         'angular-jwt',
         'LocalStorageModule',
         'ui.mask',
         'ui.event',
         'loginModule',
         'dashboardModule',
         'vacationModule',
         'inboxModule',
         'testModule'
        ]).config(function($stateProvider,$urlRouterProvider,$httpProvider,jwtInterceptorProvider, localStorageServiceProvider) {

            // used for jwt begin
            localStorageServiceProvider.setPrefix('atmbpm').setNotify(true, true)
            jwtInterceptorProvider.tokenGetter = ['jwtHelper','localStorageService',function(jwtHelper,localStorageService) {
                if (localStorageService.isSupported) {
                    return localStorageService.get('jwt');
                }
            }];
            $httpProvider.interceptors.push('jwtInterceptor');
            // used for CORS
            $httpProvider.defaults.withCredentials = true;

            // used for jwt end

            // init page
            $urlRouterProvider.otherwise('/login');

            $stateProvider.state('test', {
                url: '/test',
                templateUrl: 'modules/test/test.html',
                controller: 'TestController'
            }).state('login', {
                url: '/login',
                templateUrl: 'modules/login/login.html',
                controller: 'LoginController'
            }).state('dashboard', {
                url: '/dashboard',
                templateUrl: 'modules/dashboard/dashboard.html',
                controller: 'DashboardController'
            }).state('dashboard.inbox', {
                resolve : {
                    tasks : function(Restangular, localStorageService, jwtHelper) {
                        var jwt = localStorageService.get('jwt');
                        var detail = jwtHelper.decodeToken(jwt);
                        return Restangular.all('/api/tasks/'+detail.info.userId).getList().$object;
                    }
                },
                url: '/inbox',
                templateUrl: 'modules/inbox/inbox.html',
                controller: 'InboxController'
            }).state('dashboard.vacation', {
                url: '/vacation',
                templateUrl: 'modules/vacation/request.html',
                controller: 'VacationController'
            });
        });
});