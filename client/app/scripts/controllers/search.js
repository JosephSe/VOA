'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:SearchCtrl
 * @description
 * # SearchCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('SearchCtrl', function ($scope, $location) {
    $scope.regNum = 'A056AAb';
    $scope.search = function () {
      var payload = {
        regNum: $scope.regNum,
        make: $scope.make,
        v5c: $scope.v5c
      };
      $scope.$parent.searchPayload = payload;
      $location.path('/details');
    };
  });
