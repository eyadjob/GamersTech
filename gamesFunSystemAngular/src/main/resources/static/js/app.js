/*app name defined in  index.html using ng-app*/

var app = angular.module('userregistrationsystem', ['ngRoute', 'ngResource']);
/*
To handle a request like /home, it needs an AngularJS module, called ngRoute. To use ngRoute and inject it into your application, you use angular.module to add the ngRoute module to your app

The controller listUserController will be called when you navigate to the URL /list-all-users.

Angular phases
1- bootstrap phase,
2-compilation phase,
3-runtime data binding phase

uploading image
https://medium.com/@rameez.s.shaikh/upload-and-retrieve-images-using-spring-boot-angular-8-mysql-18c166f7bc98
*/
app.config(function($routeProvider) {
    $routeProvider.when('/', {
            templateUrl : '/template/home.html',
            controller : 'homeController'
        }).when('/list-all-users', {
        templateUrl : '/template/listuser.html',
        controller : 'listUserController'
    }).when('/register-new-user',{
        templateUrl : '/template/userregistration.html',
        controller : 'registerUserController'
    }).when('/update-user/:id',{
        templateUrl : '/template/userupdation.html' ,
        controller : 'usersDetailsController'
    }).when('/login',{
            templateUrl : '/template/login/login.html',
            controller : 'loginController'
    }).when('/logout',{
            templateUrl : '/template/login/login.html',
            controller : 'logoutController'
    }).otherwise({
            redirectTo : '/login'
    });

});


app.config(function ($httpProvider) {
    //The custom X-Requested-With line is a conventional header sent by browser clients. Spring Security responds to it by not sending a WWW-Authenticate header in a 401 response, and thus the browser will not open an authentication pop-up dialog, which is desirable in your UserRegistrationSystem application since you want to control the authentication.
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $httpProvider.interceptors.push('AuthInterceptor');

});

