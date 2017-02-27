# Define the Application Services Module
utilisateurServices = angular.module 'utilisateurServices', ['ngResource']

utilisateurServices.service 'serviceUtilisateurList', ['$http', ($http) ->
  getAllUtilisateur: ->
    console.log "Service getAllUtilisateur"
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      console.log "Service"
      console.log response
      this.response = response
]
