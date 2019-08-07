var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "../../resources/views/user/home.jsp"
    })
    .when("/users", {
        templateUrl : "../../resources/views/admin/users.jsp",
        controller : "adminUsuarioCtrl"
    })
    .when("/paris", {
        templateUrl : "paris.htm",
        controller : "parisCtrl"
    });
});

app.controller("parisCtrl", function ($scope) {
    $scope.msg = "I love Paris";
});