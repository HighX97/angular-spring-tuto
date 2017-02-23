# Define the Application Services Module
utilisateurServices = angular.module 'utilisateurServices', ['ngResource']

# Define the Utilisateur Service
utilisateurServices.factory 'Utilisateur', ['$http', ($http) ->
  getAllUtilisateur: ->
    console.log "Service getAllUtilisateur"
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      console.log "Service"
      console.log response
      return response
]
