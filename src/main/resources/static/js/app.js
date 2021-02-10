var app = angular.module('registrationapp', [ 'ngRoute', 'ngResource' ]);

app.config(function($routeProvider) {
	$routeProvider.when('/listuser', {
		templateUrl : '/template/listofusers.html',
		controller : 'listController'
	}).when('/registeruser',{
		templateUrl : '/template/registrationpage.html',
		controller : 'registerController'
	}).when('/update-user/:id',{
      		templateUrl : '/template/userinfoupdate.html' ,
      		controller : 'updateController'
    }).otherwise({
      		redirectTo : '',
      		templateUrl : '/template/home.html',
    });
});
