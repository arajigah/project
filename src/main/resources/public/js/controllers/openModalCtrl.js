angular.module('mainModule').controller('openModalCtrl', ['$scope','$uibModal', function($scope, $uibModal){

	$scope.addCollapsed = true;
	$scope.viewCollapsed = true;
    
    $scope.addCollapsedMenu = function(){
        $scope.addCollapsed = false;
        $scope.viewCollapsed = true;
    }
     $scope.viewCollapsedMenu = function(){
        $scope.addCollapsed = true;
        $scope.viewCollapsed = false;
    }
	
	$scope.openEnclosureModal = function(){
		var enclosureModal = $uibModal.open({
            animation: true,
            templateUrl: 'templates/addEnclosure.tpl.html',
            controller: 'addEnclosureCtrl'
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
