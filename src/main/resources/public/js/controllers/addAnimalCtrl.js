angular.module('mainModule').controller('addAnimalCtrl', ['$scope','$uibModalInstance','toastr','foodFactory','animalFactory', function($scope, $uibModalInstance, toastr, foodFactory, animalFactory){

	$scope.animal = {};
	$scope.foods = [];
	$scope.favoriteFood = {};
	
	var foodData = foodFactory.getAllFoods().then(
			function(success){
				$scope.foods = success.data;
			}
	)
	
	$scope.foodSettings = {externalIdProp: 'favoriteFoodId', displayProp: 'favoriteFoodName', idProp: 'favoriteFoodId', smartButtonMaxItems: 1, selectionLimit: 1};
	
	
	$scope.addAnimal = function(animal, favoriteFood){
		if($scope.validateFood(favoriteFood) && $scope.validateAnimal(animal)){
			animal.favoriteFood = favoriteFood;
			animalFactory.addAnimal(animal).then(
					function(success){
						console.log(success);
					},
					function(error){
						console.log(error);
					}
			)
		}
		else{
			toastr.error("Favorite Food is required");
		}
	}
	$scope.closeModal = function(){
		$uibModalInstance.close();
	}
	
	$scope.validateAnimal = function(animal){
		var name = animal.animalName;
		if(name.trim() != ""){
			toastr.success("woohoo");
		}
	}
	$scope.validateFood = function(favoriteFood){
		if(favoriteFood.favoriteFoodId > 0){
			return true;
		}
		else{
			return false;
		}
	}
}])