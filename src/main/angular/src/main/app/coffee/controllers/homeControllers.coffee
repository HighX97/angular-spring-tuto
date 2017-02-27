# Define the Application Controllers Module
homeControllers = angular.module 'homeControllers', []

# Define the HeaderController Controller
homeControllers.controller 'HeaderController', ['$scope',
  ($scope) ->

    $scope.pageHeading = 'AngularJS Starter Project'

]

# Define the FooterController Controller
homeControllers.controller 'FooterController', ['$scope',
  ($scope) ->

    $scope.currentDateTime = new Date()

]
