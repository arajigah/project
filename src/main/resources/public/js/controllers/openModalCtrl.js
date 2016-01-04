angular.module('mainModule').controller('openModalCtrl', ['$scope','$uibModal', function($scope, $uibModal){

	$scope.addCollapsed = true;
	$scope.viewCollapsed = true;
	
	$scope.openModal1 = function(){
		var modal1 = $uibModal.open({
            animation: true,
            templateUrl: 'templates/modalInstance1.tpl.html',
            controller: 'modalInstance1Ctrl'
        });
	}
	$scope.openModal2 = function(){
		var modal1 = $uibModal.open({
            animation: true,
            templateUrl: 'templates/modalInstance2.tpl.html',
            controller: 'modalInstance2Ctrl'
        });
	}
	$scope.openModal3 = function(){
		var modal1 = $uibModal.open({
            animation: true,
            templateUrl: 'templates/modalInstance3.tpl.html',
            controller: 'modalInstance3Ctrl'
        });
	}
}])
