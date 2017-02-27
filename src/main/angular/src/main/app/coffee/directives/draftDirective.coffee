# Define the Application Factories Module
draftDirectives = angular.module 'draftDirectives', []

draftDirectives.directive 'draftDirective', ->
  {
    template : "draft directive !!"
  }
