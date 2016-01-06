angular.module('mainModule').controller('viewSingleAnimalCtrl', ['$scope', 'animalInfo','animalFactory','$uibModal','toastr', '$window', function($scope, animalInfo, animalFactory,$uibModal, toastr, $window){
	
	$scope.animalInfo = animalInfo.data;
	
	$scope.openEditModal = function(animalId){
        var enclosureEditModalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'templates/animalEdit.tpl.html',
            controller: 'animalEditCtrl',
            resolve: {
                animalEditInfo: function(){
                    return $scope.animalInfo;
                }
            }
        });
    }
}]);