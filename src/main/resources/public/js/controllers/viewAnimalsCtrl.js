angular.module('mainModule').controller('viewAnimalsCtrl', ['$scope', 'animalFactory', function($scope, animalFactory){
	var animalData = animalFactory.getAnimals().then(
			function(success){
				$scope.animals = success.data;
			}
	)
}]);