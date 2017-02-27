# Define the Application Factories Module
utilisateurDirectives = angular.module 'utilisateurDirectives', []

utilisateurDirectives.directive 'utilisateurDirective', ->
  {
    templateUrl: 'assets/app/partials/utilisateur/utilisateur-add.html'
  }
