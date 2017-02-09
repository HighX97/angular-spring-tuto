# Define the Application Services Module
utilisateurServices = angular.module 'utilisateurServices', ['ngResource']

# Define the Greeting Service
utilisateurServices.factory 'Utilisateur', ['$resource',
($resource) ->
$resource 'assets/app/data/utilisateurs/:utilisateurId.json', {}, {
query:
  method: 'GET'
  params:
    utilisateurId: 'utilisateurs'
    isArray: true
  }
]
