# Define the Application Controllers Module
utilisateurControllers = angular.module 'utilisateurControllers', []

# Define the UtilisateurListController Controller
utilisateurControllers.controller 'UtilisateurListController', ['$scope','$http', 'Utilisateur'
  ($scope, $http, Utilisateur) ->
    console.log "*************************** Avant HTTP GET "
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      console.log "HTTP GET"
      $scope.utilisateurs = response.data
      $scope.content = response.data
      $scope.statuscode = response.status
      $scope.statustext = response.statusText
    console.log "Après HTTP GET ***************************"

  #  $scope.utilisateurs = Utilisateur.query()
    $scope.utilisateurSort = 'text'

    $scope.utilisateurInfoClass = 'text-muted'

]

# Define the UtilisateurDetail Controller
utilisateurControllers.controller 'UtilisateurDetailController', ['$scope','$http', '$routeParams', 'Utilisateur',
  ($scope, $http, $routeParams, Utilisateur) ->
        console.log 'http://localhost:8080/maps/utilisateur/'+$routeParams.utilisateurId
        $http.get('http://localhost:8080/maps/utilisateur/'+$routeParams.utilisateurId).then (response) ->
            $scope.utilisateur = response.data
            console.log '$scope.utilisateur'
            console.log response.data


]
