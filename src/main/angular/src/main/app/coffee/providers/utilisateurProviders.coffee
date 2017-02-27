# Define the Application Providers Module
utilisateurProviders = angular.module 'utilisateurProviders', ['ngResource']

#AngularJS Provider Issue #2
#http://jsfiddle.net/thomporter/zjFp4/1/
###
utilisateurProviders.provider 'helloWorld', ->
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
utilisateurProviders.config (helloWorldProvider) ->
  helloWorldProvider.setName 'World'
  return
#provider style, full blown, configurable version


#hey, we can configure a provider!
utilisateurProviders.config (helloWorldProvider) ->
helloWorldProvider.setName('Lowx')

utilisateurProviders.provider 'providerUtilisateurList', ['$http', ($http) ->
  @$get = ->
    {utilisateurFactories
      getAllUtilisateur: ->
        console.log "Service getAllUtilisateur"
        $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
          console.log "Service"
          console.log response
          this.response = response
    }
]
###
