angular.module('mainModule').controller('viewSingleEnclosureCtrl', ['$scope', 'enclosureInfo', function($scope, enclosureInfo){
	$scope.enclosureInfo = enclosureInfo.data;
}]);