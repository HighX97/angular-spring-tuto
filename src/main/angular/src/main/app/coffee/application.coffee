# The Angular Application Module

myApp = angular.module 'myApp', [
  #
  'homeControllers',
  'greetingControllers',
  'utilisateurControllers',
  'draftControllers',
  #
  'greetingServices',
  'utilisateurServices',
  #
  'utilisateurFactories',
  #
  'utilisateurDirectives',
  'draftDirectives',
  #
  'numberFilters',
  #
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
        controller: 'GreetingDetailController'
      .when '/utilisateurs',
        templateUrl: 'assets/app/partials/utilisateur/utilisateur-list.html'
        controller: 'UtilisateurListController'
      .when '/utilisateurs/add',
        templateUrl: 'assets/app/partials/utilisateur/utilisateur-add.html'
        controller: 'UtilisateurAddController'
      .when '/utilisateurs/updt/:utilisateurId',
        templateUrl: 'assets/app/partials/utilisateur/utilisateur-updt.html'
        controller: 'UtilisateurUpdtController'
      .when '/utilisateurs/:utilisateurId',
        templateUrl: 'assets/app/partials/utilisateur/utilisateur-detail.html'
        controller: 'UtilisateurDetailController'
      .when '/draft',
        templateUrl: 'assets/app/partials/draft/draft.html'
        controller: 'numberFiltersController'
      .otherwise
        redirectTo: '/home'
]
