define([
    'angular',
    'loginModule',
    'dashboardModule',
    'usersModule',
    'customerModule',
    'masterModule',
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
         'loginModule',
         'dashboardModule',
         'usersModule',
         'customerModule',
         'masterModule',
         'projectModule',
         'brokerModule',
         'buyingModule',
         'sellingModule',
         'repositoryModule',
         'allianceModule',
         'uploadModule'
        ])
        .config(['$stateProvider','$urlRouterProvider','$httpProvider','RestangularProvider','jwtInterceptorProvider','localStorageServiceProvider',function($stateProvider,$urlRouterProvider, $httpProvider,RestangularProvider,jwtInterceptorProvider, localStorageServiceProvider) {
            // used for CORS
            //$httpProvider.defaults.withCredentials = true;
            //RestangularProvider.setBaseUrl("http://192.168.0.103:3040");
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

            $urlRouterProvider.otherwise('/login');

            $stateProvider
                //登录
                .state('login', {
                    url: '/login',
                    templateUrl: 'modules/login/login.html',
                    controller : 'LoginController'
                })
                // 控制面板
                .state('dashboard', {
                    url: '/dashboard',
                    template: '<ui-view />',
                    controller : 'DashboardController'
                })
                // 重置密码
                .state('dashboard.reset', {
                    url: '/reset',
                    templateUrl: 'modules/login/forget.html',
                    controller : 'ForgetController'
                })
                .state('dashboard.project', {
                    url: '/project',
                    templateUrl: 'modules/project/project.list.html',
                    controller : 'ProjectListController'
                })
                .state('dashboard.customer', {
                    url: '/customer',
                    templateUrl: 'modules/customer/customer.list.html',
                    controller : 'CustomerListController'
                })
                // 用户管理
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
                })
                // 客户管理路由器
                .state('customer', {
                    url: '/customer',
                    abstract: true,
                    template: '<ui-view />',
                }).state('customer.list', {
                    url: '/list',
                    templateUrl: 'modules/customer/customer.list.html',
                    controller: 'CustomerListController'
                }).state('customer.edit', {
                    url: '/edit/:id',
                    templateUrl: 'modules/customer/customer.edit.html',
                    controller: 'CustomerEditController'
                }).state('customer.add', {
                    url: '/add',
                    templateUrl: 'modules/customer/customer.add.html',
                    controller: 'CustomerAddController'
                })
                // 文件上传管理路由配置
                .state('upload', {
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