'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:DetailsCtrl
 * @description
 * # DetailsCtrl
 * Controller of the clientAppvgc
 */
angular.module('clientApp')
  .controller('DetailsCtrl', function ($scope, $http, $location) {
    $scope.details = {}
    $scope.loadData = function() {
      var payload = $scope.$parent.searchPayload;
      if(undefined === payload) {
        $location.path('/search');
      } else {
        $http.post('app/vehicle/search', payload)
          .success(function (data) {
            $scope.details = data
          })
          .error(function (err) {
            $log.debug(err);
          });
      }
    }
    $scope.$on('$viewContentLoaded', function () {
      $scope.loadData();
    });
  });

/*
{"mfg":"2006",
  "weight":"N/A",
  "wheelPlan":"2 AXLE RIGID BODY",
  "tax":"21 Feb 2016",
  "fuelType":"Petrol",
  "dateOfReg":"10 Aug 2006",
  "mot":"21 Sep 2016",
  "color":"Black",
  "typ":"M2",
  "make":"Honda",
  "emissions":"149",
  "cc":"1799",
  "regNum":"A056AAb"}*/
