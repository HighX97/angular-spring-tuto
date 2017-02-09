# The Angular Application Module

myApp = angular.module 'myApp', [
  'homeControllers',
  'greetingControllers',
  'greetingServices',
  'utilisateurControllers',
  'utilisateurServices',
  'ngRoute',
  'ngAnimate',
  'mgcrea.ngStrap'
]

# Configure the ngRoute Module
myApp.config ['$routeProvider',
  ($routeProvider) ->
    $routeProvider .when '/home',
        templateUrl: 'assets/app/partials/home.html'
      .when '/greetings',
        templateUrl: 'assets/app/partials/greeting/greeting-list.html'
        controller: 'GreetingListController'
      .when '/greetings/:greetingId',
        templateUrl: 'assets/app/partials/greeting/greeting-detail.html'
        controller: 'GreetingDetailController',
      .when '/utilisateurs',
        templateUrl: 'assets/app/partials/utilisateur/utilisateur-list.html'
        controller: 'UtilisateurListController'
      .when '/utilisateurs/:utilisateurId',
        templateUrl: 'assets/app/partials/utilisateur/utilisateur-detail.html'
        controller: 'UtilisateurDetailController'
      .otherwise
        redirectTo: '/home'
]
