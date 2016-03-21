'use strict';

socialNetworkApp.controller('ConfigurationCtrl', ["$scope","ConfigurationService", function ConfigurationCtrl($scope,ConfigurationService) {


  $('#configuration').show({
    duration: 500
  });

  $scope.isRequestInProgress = false;

  ConfigurationService.loadBandwith().$promise.then(function (responseData) {
      //EMIT SUCCESS
      $scope.bandwidth = responseData;
      console.log(responseData)
    })
    .catch(function (response) {
      Materialize.toast("Oops! ocurrió un error cargando la configuración, favor intentelo mas tarde.", 5000, "error");
    })
    .finally(function(){
      angular.element("#configuration .progress").hide();
    });


  $scope.saveConfiguration = function(configurationData){
    angular.element("#configuration .progress").show();
    $scope.isRequestInProgress = true;
    ConfigurationService.saveBandwidth(configurationData,function(){
      angular.element("#configuration .progress").hide();
      $scope.isRequestInProgress = false;
    });
  }
}]);
