angular.module('mainModule').controller('addFoodCtrl', ['$scope','$uibModalInstance','toastr', function($scope, $uibModalInstance, toastr){

	$scope.helloMessage = "modal3";
	
	$scope.closeModal = function(){
		$uibModalInstance.close();
	}
	$scope.toastr = function(){
		$uibModalInstance.close();
		toastr.success('woohoo','Success');
	}
}])