# Define the Application Services Module
utilisateurServices = angular.module 'utilisateurServices', ['ngResource']

# Define the Utilisateur Service
utilisateurServices.factory 'factoryUtilisateurList', ['$http', ($http) ->
  getAllUtilisateur: ->
    console.log "Service getAllUtilisateur"
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      console.log "Service"
      console.log response
      return response
]

utilisateurServices.service 'serviceUtilisateurList', ['$http', ($http) ->
  getAllUtilisateur: ->
    console.log "Service getAllUtilisateur"
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      console.log "Service"
      console.log response
      this.response = response
]

###
utilisateurServices.provider 'providerUtilisateurList', ['$http', ($http) ->
  getAllUtilisateur: ->
    console.log "Service getAllUtilisateur"
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      console.log "Service"
      console.log response
      resp = response
      @$get = ->
          {
            response : resp
          }
]
###

utilisateurServices.factory 'UtilisateurOne', ['$http', ($http) ->
  getUtilisateur: ->
    console.log "Service getAllUtilisateur"
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      console.log "Service"
      console.log response
      return response
]
