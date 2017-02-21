# Define the Application Services Module
utilisateurServices = angular.module 'utilisateurServices', ['ngResource']

# Define the Utilisateur Service
utilisateurServices.factory 'Utilisateur', ['$http', ($http) ->
    getAllUtilisateur: ->
      request = $http.get 'http://localhost:8080/maps/utilisateur/'
      request.then (result) =>
        @utilisateurs = result.data
        console.log @utilisateurs
        @utilisateurs
]
