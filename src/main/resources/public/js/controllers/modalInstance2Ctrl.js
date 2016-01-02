angular.module('mainModule').controller('modalInstance2Ctrl', ['$scope','$uibModalInstance','toastr', function($scope, $uibModalInstance, toastr){

	$scope.helloMessage = "modal2";
	
	$scope.closeModal = function(){
		$uibModalInstance.close();
	}
	$scope.toastr = function(){
		$uibModalInstance.close();
		toastr.success('woohoo','Success');
	}
}])