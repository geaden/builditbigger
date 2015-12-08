(function() {
    'use strict';

    angular.module('JokeApp', ['ngMaterial'])
    .config(function($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('cyan')
            .accentPalette('indigo');
    })
    .controller('JokeCtrl', function($scope, $http, $sce, $mdDialog) {
        /** Indicates if loading is in progress.*/
        $scope.showProgress = false;

        $scope.joke = null;

        $scope.showAboutDialog = function(ev) {
            $mdDialog.show({
              clickOutsideToClose: true,
              scope: $scope,        // use parent scope in template
              preserveScope: true,  // do not forget this if use parent scope
              // Since GreetingController is instantiated with ControllerAs syntax
              // AND we are passing the parent '$scope' to the dialog, we MUST
              // use 'vm.<xxx>' in the template markup
              templateUrl: '/partials/about.html',
              controller: function DialogController($scope, $mdDialog) {
                $scope.closeDialog = function() {
                  $mdDialog.hide();
                }
              }
           });
        }

        /** Loads a joke from API.*/
        $scope.tellJoke = function() {
            $scope.showProgress = true;
            $http.get('/_ah/api/jokesApi/v1/joke').success(function(data) {
                $scope.showProgress = false;
                $scope.joke = data.data;
            });
        };
    });
}());