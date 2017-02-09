# Define the Application Services Module
greetingServices = angular.module 'greetingServices', ['ngResource']

# Define the Greeting Service
greetingServices.factory 'Greeting', ['$resource',
  ($resource) ->
    $resource 'assets/app/data/greetings/:greetingId.json', {}, {
      query:
        method: 'GET'
        params:
          greetingId: 'greetings'
        isArray: true
    }
]
