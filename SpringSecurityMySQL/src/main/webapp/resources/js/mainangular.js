var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "../../resources/views/admin/home.jsp"
    })
    .when("/users", {
        templateUrl : "../../resources/views/admin/users.jsp",
        controller : "adminUsuarioCtrl"
    })
    .when("/paris", {
        templateUrl : "paris.htm",
        controller : "parisCtrl"
    })
    .when("/reportusers", {
        templateUrl : "../../resources/views/admin/reportusers.jsp",
        controller : "reportusersCtrl"
    });
});

app.controller("parisCtrl", function ($scope) {
    $scope.msg = "I love Paris";
});