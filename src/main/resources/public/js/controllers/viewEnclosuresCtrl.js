angular.module('mainModule').controller('viewAllEnclosuresCtrl', ['$scope', 'enclosureFactory', function($scope, enclosureFactory){
	$scope.enclosureData = enclosureFactory.getAllEnclosures().then(
			function(success){
				$scope.enclosures = success.data;
			}
	)
}]);