angular.module('mainModule').controller('modalInstance1Ctrl', ['$scope','$uibModalInstance','toastr', function($scope, $uibModalInstance, toastr){

	$scope.helloMessage = "modal1";
	
	$scope.closeModal = function(){
		$uibModalInstance.close();
	}
	$scope.toastr = function(){
		$uibModalInstance.close();
		toastr.success('woohoo','Success');
	}
}])
