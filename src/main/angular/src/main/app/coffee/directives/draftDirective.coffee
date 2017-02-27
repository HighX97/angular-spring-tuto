# Define the Application Factories Module
draftDirectives = angular.module 'draftDirectives', []

#By default the value is EA, meaning that both Element names and attribute names can invoke the directive.
draftDirectives.directive 'draftDirective', ->
  {
    restrict : "EACM",
    transclude : false,
    template : "draft directive !!"
  }

#By default the value is EA, meaning that both Element names and attribute names can invoke the directive.
draftDirectives.directive 'otherDraftDirective', ->
  {
    restrict : "EACM",
    transclude : false,
    template : "otherdraft directive !!"
  }

draftDirectives.directive 'transcludeDemo', ->
  {
    restrict : "EACM",
    transclude : true,
    templateUrl: 'assets/app/partials/draft/transcludeDemo.html'
  }
