# Define the Application Factories Module
utilisateurFactories = angular.module 'utilisateurFactories', ['ngResource']


# Define the Utilisateur Service
utilisateurFactories.factory 'factoryUtilisateurList', ['$http', ($http) ->
  getAllUtilisateur: ->
    console.log "Service getAllUtilisateur"
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      console.log "Service"
      console.log response
      return response
]
# Define the Utilisateur Service
utilisateurFactories.factory 'factoryUtilisateurOne', ['$http', ($http) ->
  getUtilisateur : (id) ->
      $http.get('http://localhost:8080/maps/utilisateur/'+id).then (response) ->
        console.log response
        console.log '$scope.utilisateur'
        console.log response.data
        return response
]
# Define the Utilisateur Service
utilisateurFactories.factory 'factoryUtilisateurDel', ['$http', ($http) ->
  delUtilisateur : (id) ->
      $http.delete('http://localhost:8080/maps/utilisateur/'+id).then (response) ->
        console.log response
        console.log '$scope.utilisateur'
        console.log response.data
        return response
]
# Define the Utilisateur Service
utilisateurFactories.factory 'factoryUtilisateurNew', ['$http', ($http) ->
  addUtilisateur : (utilisateur) ->
    $http.post('http://localhost:8080/maps/utilisateur', utilisateur).then (response) ->
      if response.data.success
        if response.data.response.length > 0
          console.log  response.data.message
        else
          console.log  response.data.message
      else
        console.log  response.data.message
      return response
]
# Define the Utilisateur Service
utilisateurFactories.factory 'factoryUtilisateurUpdt', ['$http', ($http) ->
  updateUtilisateur :  (utilisateur) ->
    console.log "factory updt"
    console.log 'http://localhost:8080/maps/utilisateur/'+utilisateur.id
    $http.put('http://localhost:8080/maps/utilisateur/'+utilisateur.id, utilisateur).then (response) ->
      console.log "PUT factory updt"
      if response.data.success
        if response.data.response.length > 0
          console.log  response.data.message
        else
          console.log  response.data.message
      else
        console.log  response.data.message
      return response
]
