# Define the Application Factories Module
utilisateurDirectives = angular.module 'utilisateurDirectives', []

utilisateurDirectives.directive 'utilisateur-directive', ->
  {
    restrict: 'EAC'
    require: '?ngModel'
    link: ($scope, element, attrs, controller) ->
      element.text 'iambar'
      return
  }
