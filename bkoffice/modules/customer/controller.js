/**
 * Created by cmwin on 10/23/15.
 */
define(['angular', 'uiRouter'], function(angular) {
    angular.module('customerControllers', ['restangular','ui.router'])
        .controller('CustomerController', function($scope) {
            $scope.message = '';
        })
        .controller('CustomerListController', function($scope,$state,Restangular) {
            $scope.edit = function(_id) {
                $state.go('customer.edit', {id:_id});
            }

            $scope.delete = function(_id) {

            }

        }).controller('CustomerAddController', function($scope,$state,Restangular) {
            $scope.customer = {
                name: "测试",                           // 客户姓名
                gender : "_MALE",                          // 先生、女士
                mobile: "139676768989",                 // 客户电话
                project: "成品格调",                     // 到访楼盘
                visitNo: "001-002-003",                 // 三联单号
                ext: "1",                               // 报备成功、失败
                features:{                              // object
                    access_time:[                       //Array     标签类型
                        {
                            text : "2015-10-10",            // 到访时间
                            foreColor: "#123456",                 // 前景色
                            backColor:"#123456"                // 背景色
                        }
                    ],
                    customer_status :[                         //Array      标签类型
                        {
                            "text":"到访",         // 客户状态
                            "foreColor": "#123456",   // 前景色
                            "backColor":"#123456"    // 背景色
                        }
                    ]
                },
                realtor: {                                // object
                    type:[                                //Array      标签类型
                        {
                            name : "13591770319",                           // 经纪人
                            _id  : "20"
                        }
                    ]
                }
            };

            $scope.create = function() {
                Restangular.all('/customer/add').post($scope.customer, function (customer) {

                });
                $state.go('customer.list');
            };

            $scope.back = function() {
                $state.go('customer.list');
            }
        }).controller('CustomerEditController', function($scope,$state,Restangular,$stateParams) {
            $scope.save = function () {
                $state.transitionTo('customer.list');
            };

            $scope.back = function() {
                $state.go('customer.list');
            };
        });
});