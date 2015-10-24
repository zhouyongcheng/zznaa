define([
    'angular',
    'uiRouter',
    'fileUploadShim',
    'fileUpload',
    'restangular',
    'angularJwt',
    'angularLocalStorage',
    'ngFileUpload',
    'usersModule',
    'masterModule',
    'loginModule',
    'brokerModule',
    'buyingModule',
    'sellingModule',
    'repositoryModule',
    'allianceModule',
    'masterModule',
    'projectModule',
    'uploadModule'
], function(angular) {
    return angular.module('portal',
        ['ui.router',
         'ngFileUpload',
         'restangular',
         'angular-jwt',
         'LocalStorageModule',
         'usersModule',
         'masterModule',
         'projectModule',
         'loginModule',
         'brokerModule',
         'buyingModule',
         'sellingModule',
         'repositoryModule',
         'allianceModule',
         'uploadModule'
        ])
        .config(['$stateProvider','$httpProvider','RestangularProvider','jwtInterceptorProvider','localStorageServiceProvider',function($stateProvider,$httpProvider,RestangularProvider,jwtInterceptorProvider, localStorageServiceProvider) {
            // used for CORS
            $httpProvider.defaults.withCredentials = true;
            RestangularProvider.setBaseUrl("http://localhost:3000");
            localStorageServiceProvider.setPrefix('portal').setNotify(true, true)

            // used for jwt begin
            jwtInterceptorProvider.tokenGetter = ['jwtHelper','localStorageService',function(jwtHelper,localStorageService) {
                if (localStorageService.isSupported) {
                    var jwt = localStorageService.get('jwt');
                    //var detail = jwtHelper.decodeToken(jwt);
                    //console.log("---------------------------");
                    //console.log("detail token : " + detail);
                    //console.log("---------------------------");
                    return jwt;
                }
            }];
            $httpProvider.interceptors.push('jwtInterceptor');
                // used for jwt end

            $stateProvider
                .state('users', {
                    url: '/users',
                    abstract: true,
                    templateUrl: 'modules/users/users.html',
                }).state('users.list', {
                    resolve : {
                        users : function(Restangular) {
                            return Restangular.all('/users').getList().$object
                        }
                    },
                    url: '/list',
                    templateUrl: 'modules/users/users.list.html',
                    controller: 'UsersListController'
                }).state('users.edit', {
                    url: '/edit/:id',
                    templateUrl: 'modules/users/users.edit.html',
                    controller: 'UsersEditController'
                }).state('users.add', {
                    url: '/add',
                    templateUrl: 'modules/users/users.add.html',
                    controller: 'UsersAddController'
                }).state('upload', {
                    url: '/upload',
                    templateUrl: 'modules/upload/upload.html',
                    controller: 'UploadController'
                }).state('master', {
                    url: '/master',
                    templateUrl: 'modules/master/master.html',
                    controller: 'MasterController'
                }).state('master.list', {
                    resolve : {
                        categories : function(Restangular) {
                            return Restangular.all('/api/categories').getList().$object;
                        }
                    },
                    url: '/list',
                    templateUrl: 'modules/master/list.html',
                    controller: 'MasterListController'
                }).state('master.create', {
                    url: '/create',
                    templateUrl: 'modules/master/create.html',
                    controller: 'MasterCreateController'
                }).state('master.update', {
                    url: '/update/:category/:code',
                    templateUrl: 'modules/master/update.html',
                    controller: 'MasterUpdateController'
                }).state('login', {
                    url: '/login',
                    templateUrl: 'modules/login/login.html',
                    controller : 'LoginController'
                }).state('broker', {
                    url: '/broker',
                    templateUrl: 'modules/broker/broker.html'
                }).state('buying', {
                    url: '/buying',
                    templateUrl: 'modules/buying/buying.html',
                    controller: 'BuyingController'
                }).state('selling', {
                    url: '/selling',
                    templateUrl: 'modules/selling/selling.html',
                    controller : 'SellingController'
                }).state('repository', {
                    url: '/repository',
                    templateUrl: 'modules/repository/repository.html'
                }).state('alliance', {
                    url: '/alliance',
                    templateUrl: 'modules/alliance/alliance.html',
                    controller : 'AllianceController'
                }).state('projects', {
                    url: '/projects',
                    templateUrl : 'modules/project/projects.html'
                }).state('projects.detail', {
                    views : {
                        'filters' : {
                            templateUrl : 'modules/project/filters.html'
                        },
                        'menu' : {
                            templateUrl : 'modules/project/menu.html'
                        },
                        'content' : {
                            templateUrl:'modules/project/content.html'
                        }
                    }
                }).state('projects.list', {
                    url:'/list',
                    //templateUrl:'modules/project/projects.list.html',
                    views : {
                        'filters' : {
                            templateUrl : 'modules/project/filters.html'
                        },
                        'menu' : {
                            templateUrl : 'modules/project/menu.html'
                        },
                        'content' : {
                            templateUrl:'modules/project/content.html'
                        }
                    }
                }).state('projects.add', {
                    url:'/add',
                    //templateUrl:'modules/project/projects.add.html',
                    views : {
                        'filters' : {
                            templateUrl : 'modules/project/filters.html'
                        },
                        'menu' : {
                            templateUrl : 'modules/project/menu.html'
                        },
                        'content' : {
                            templateUrl:'modules/project/content.html'
                        }
                    }
                });
            }]);
});