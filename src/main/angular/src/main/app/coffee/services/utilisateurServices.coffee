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


#AngularJS Provider Issue #2
#http://jsfiddle.net/thomporter/zjFp4/1/
utilisateurServices.provider 'helloWorld', ->
  @name = 'Default'

  @$get = ->
    name = @name
    { sayHello: ->
      'Hello, ' + name + '!'
 }

  @setName = (name) ->
    @name = name
    return

  return
utilisateurServices.config (helloWorldProvider) ->
  helloWorldProvider.setName 'World'
  return
#provider style, full blown, configurable version


#hey, we can configure a provider!
###
utilisateurServices.config (helloWorldProvider) ->
helloWorldProvider.setName('Lowx')

utilisateurServices.provider 'providerUtilisateurList', ['$http', ($http) ->
  @$get = ->
    {
      getAllUtilisateur: ->
        console.log "Service getAllUtilisateur"
        $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
          console.log "Service"
          console.log response
          this.response = response
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
