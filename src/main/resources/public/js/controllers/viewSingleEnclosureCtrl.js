angular.module('mainModule').controller('viewSingleEnclosureCtrl', ['$scope', 'enclosureInfo','enclosureFactory','$uibModal','toastr', '$window', function($scope, enclosureInfo, enclosureFactory,$uibModal, toastr, $window){
	$scope.enclosureInfo = enclosureInfo.data;
	
	$scope.deleteEnclosure = function(enclosureId){
		enclosureFactory.deleteEnclosure(enclosureId).then(
			function(success){
				 $window.location.href = '/';
			}
		)
	}
	
	$scope.openEditModal = function(enclosureId){
        var enclosureEditModalInstance = $uibModal.open({
            animation: true,
            templateUrl: 'templates/enclosureEdit.tpl.html',
            controller: 'enclosureEditCtrl',
            resolve: {
                enclosureEditInfo: function(enclosureFactory){
                    return enclosureFactory.getEnclosureById(enclosureId);
                }
            }
        });
    }
}]);