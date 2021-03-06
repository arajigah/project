angular.module('mainModule').controller('addAnimalCtrl', ['$scope','$uibModalInstance','toastr','foodFactory','animalFactory', function($scope, $uibModalInstance, toastr, foodFactory, animalFactory){

	$scope.animal = {};
	$scope.animal.animalName = "";
	$scope.animal.scientificName = "";
	$scope.animal.informationalLink = "";
	$scope.foods = [];
	$scope.favoriteFood = {};
	
	var foodData = foodFactory.getAllFoods().then(
			function(success){
				$scope.foods = success.data;
			}
	)
	
	$scope.foodSettings = {externalIdProp: 'favoriteFoodId', displayProp: 'favoriteFoodName', idProp: 'favoriteFoodId', smartButtonMaxItems: 1, selectionLimit: 1};
	$scope.foodText = {buttonDefaultText: 'Select Food'};
	
	
	$scope.addAnimal = function(animal, favoriteFood){
		if($scope.validateAnimal(animal, favoriteFood)){
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
	}
	$scope.closeModal = function(){
		$uibModalInstance.close();
	}
	
	$scope.validateAnimal = function(animal, favoriteFood){
		var result = true;
		var animalName = animal.animalName.trim();
		var scientificName = animal.scientificName.trim();
		var link = animal.informationalLink.trim();
		if(typeof favoriteFood.favoriteFoodId === 'undefined'){
			result = false;
			toastr.error("Favorite Food is Required");
		}
		if(animalName == ""){
			result = false;
			toastr.error("Animal Name is Required");
		}
		if(scientificName == ""){
			result = false;
			toastr.error("Scientific Name is Required");
		}
		if(link == ""){
			result = false;
			toastr.error("Informational Link is Required");
		}
		else if(link.indexOf('.') == -1){
			result = false;
			toastr.error("Informational Link is Invalid");
		}
		return result;
	}
}])