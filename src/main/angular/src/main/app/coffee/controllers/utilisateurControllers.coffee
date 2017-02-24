# Define the Application Controllers Module
utilisateurControllers = angular.module 'utilisateurControllers', []

# Define the UtilisateurListController Controller
utilisateurControllers.controller 'UtilisateurListController', ['$scope',
'$http',
'factoryUtilisateurList',
'serviceUtilisateurList',

($scope, $http, factoryUtilisateurList,serviceUtilisateurList) ->
    serviceUtilisateurList.getAllUtilisateur().then (response) ->
      $scope.utilisateurs = response.data
      $scope.statuscode = response.status
      $scope.statustext = response.statusText
      $scope.utilisateurSort = 'text'
      $scope.utilisateurInfoClass = 'text-muted'
      ###
    factoryUtilisateurList.getAllUtilisateur().then (response) ->
      console.log response
      $scope.utilisateurs = response.data
      $scope.statuscode = response.status
      $scope.statustext = response.statusText
      $scope.utilisateurSort = 'text'
      $scope.utilisateurInfoClass = 'text-muted'
      ###
      ###
    serviceUtilisateurList.getAllUtilisateur().then (response) ->
      console.log response
      $scope.utilisateurs = response.data
      $scope.statuscode = response.status
      $scope.statustext = response.statusText
      $scope.utilisateurSort = 'text'
      $scope.utilisateurInfoClass = 'text-muted'
      ###
]

# Define the UtilisateurDetail Controller
utilisateurControllers.controller 'UtilisateurDetailController', ['$scope',
'$http',
'$routeParams',
'factoryUtilisateurOne',
($scope, $http, $routeParams, factoryUtilisateurOne) ->
  factoryUtilisateurOne.getUtilisateur($routeParams.utilisateurId).then (response) ->
    $scope.utilisateur = response.data
    $scope.statuscode = response.status
    $scope.statustext = response.statusText
]


# Define the UtilisateurAdd Controller
utilisateurControllers.controller 'UtilisateurAddController', ['$scope','$http', '$routeParams',
'factoryUtilisateurNew',
($scope, $http, $routeParams, factoryUtilisateurNew) ->
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
    factoryUtilisateurNew.addUtilisateur()$scope.utilisateur).then (result) ->
      if result.data.success
        if result.data.result.length > 0
          console.log  result.data.message
        else
          console.log  result.data.message
      else
        console.log  result.data.message
]
