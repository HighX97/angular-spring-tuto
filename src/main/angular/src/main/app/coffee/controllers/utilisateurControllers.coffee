# Define the Application Controllers Module
utilisateurControllers = angular.module 'utilisateurControllers', []

# Define the UtilisateurListController Controller
utilisateurControllers.controller 'UtilisateurListController', ['$scope','$http', 'Utilisateur'
($scope, $http, Utilisateur) ->
    $scope.utilisateurs = Utilisateur.get
    $http.get('http://localhost:8080/maps/utilisateur').then (response) ->
      $scope.utilisateurs = response.data
      $scope.statuscode = response.status
      $scope.statustext = response.statusText
      $scope.utilisateurSort = 'text'
      $scope.utilisateurInfoClass = 'text-muted'
]

# Define the UtilisateurDetail Controller
utilisateurControllers.controller 'UtilisateurDetailController', ['$scope','$http', '$routeParams', 'Utilisateur',
($scope, $http, $routeParams, Utilisateur) ->
  $http.get('http://localhost:8080/maps/utilisateur/'+$routeParams.utilisateurId).then (response) ->
    $scope.utilisateur = response.data
    $scope.statuscode = response.status
    $scope.statustext = response.statusText
    console.log '$scope.utilisateur'
    console.log response.data
]


# Define the UtilisateurAdd Controller
utilisateurControllers.controller 'UtilisateurAddController', ['$scope','$http', '$routeParams', 'Utilisateur',
($scope, $http, $routeParams, Utilisateur) ->
  $scope.utilisateur = {
    "nom": "",
    "phone": "",
    "mail": "",
    "password": ""
  }
  $scope.confirmPassword = ""
  console.log 'CreateUtilisateur'

  $scope.createUtilisateur = ->
    console.log "CreateUtilisateur"
    console.log $scope.utilisateur
    $http.post('http://localhost:8080/maps/utilisateur', $scope.utilisateur).then (result) ->
      if result.data.success
        if result.data.result.length > 0
          console.log  result.data.message
        else
          console.log  result.data.message
      else
        console.log  result.data.message
]
