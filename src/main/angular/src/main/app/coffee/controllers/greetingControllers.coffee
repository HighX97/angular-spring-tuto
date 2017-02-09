# Define the Application Controllers Module
greetingControllers = angular.module 'greetingControllers', []

# Define the GreetingListController Controller
greetingControllers.controller 'GreetingListController', ['$scope', 'Greeting'
  ($scope, Greeting) ->

    $scope.greetings = Greeting.query()

    $scope.greetingSort = 'text'

    $scope.greetingInfoClass = 'text-muted'

]

# Define the GreetingDetail Controller
greetingControllers.controller 'GreetingDetailController', ['$scope', '$routeParams', 'Greeting',
  ($scope, $routeParams, Greeting) ->

    $scope.greeting = Greeting.get {greetingId: $routeParams.greetingId}

]
