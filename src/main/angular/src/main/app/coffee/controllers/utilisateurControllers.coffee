# Define the Application Controllers Module
utilisateurControllers = angular.module 'utilisateurControllers', []

# Define the UtilisateurListController Controller
utilisateurControllers.controller 'UtilisateurListController', ['$scope',
'$http',
'factoryUtilisateurList',
'serviceUtilisateurList',
'factoryUtilisateurDel',

($scope, $http, factoryUtilisateurList,serviceUtilisateurList, factoryUtilisateurDel) ->


    $scope.delUtilisateur = (id)->
      console.log "DeleteUtilisateur BEGIN"
      factoryUtilisateurDel.delUtilisateur(id).then (response) ->
        console.log "DeleteUtilisateur END"

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

($scope, $http, $routeParams,factoryUtilisateurOne) ->
  factoryUtilisateurOne.getUtilisateur($routeParams.utilisateurId).then (response) ->
    $scope.utilisateur = response.data
    $scope.statuscode = response.status
    $scope.statustext = response.statusText
]

utilisateurControllers.controller 'UtilisateurDeleteController', ['$scope',
'$http',
'$routeParams',
'factoryUtilisateurDel',
'$location',
($scope, $http, $routeParams,factoryUtilisateurDel ,$location) ->
  $scope.delUtilisateur = ->
    console.log "DeleteUtilisateur"
    factoryUtilisateurDel.delUtilisateur($routeParams.utilisateurId).then (response) ->
      $scope.utilisateur = response.data
      $scope.statuscode = response.status
      $scope.statustext = response.statusText
]


# Define the UtilisateurAdd Controller
utilisateurControllers.controller 'UtilisateurAddController', ['$scope','$http', '$routeParams',
'factoryUtilisateurNew','$location',
($scope, $http, $routeParams, factoryUtilisateurNew, $location) ->
  $scope.utilisateur = {
    "nom": "",
    "phone": "",
    "mail": "",
    "password": ""
    "confirmPassword":""
  }
  $scope.confirmPassword = ""
  console.log 'CreateUtilisateur'

  $scope.createUtilisateur = ->
    console.log "CreateUtilisateur"
    console.log $scope.utilisateur
    formValide = true
    console.log "formValide : "+formValide
    if ($scope.utilisateur.nom == null || $scope.utilisateur.nom == "")
      console.log "nom ISSUE"
      formValide = false
      console.log "formValide : "+formValide
    if ($scope.utilisateur.phone == null || $scope.utilisateur.phone == "")
      console.log "phone ISSUE"
      formValide = false
      console.log "formValide : "+formValide
    if ($scope.utilisateur.mail == null || $scope.utilisateur.mail == "")
      console.log "mail ISSUE"
      formValide = false
      console.log "formValide : "+formValide
    console.log "$scope.confirmPassword : "+$scope.utilisateur.confirmPassword
    console.log "$scope.utilisateur.password : "+$scope.utilisateur.password
    if ($scope.utilisateur.password != $scope.utilisateur.confirmPassword)
      console.log "password ISSUE"
      formValide = false
      console.log formValide
    console.log "formValide : "+formValide
    console.log "formValide : "+formValide
    if formValide
      factoryUtilisateurNew.addUtilisateur($scope.utilisateur).then (result) ->
        if result.data.success
          if result.data.result.length > 0
            console.log  result.data.message
            console.log "$location.path('/utilisateurs')"
            $location.path('/utilisateurs')
          else
            console.log  result.data.message
            console.log "$location.path('/utilisateurs')"
            $location.path('/utilisateurs')
        else
          console.log  result.data.message
          console.log "$location.path('/utilisateurs')"
          $location.path('/utilisateurs')
    else
      console.log "None"
]
