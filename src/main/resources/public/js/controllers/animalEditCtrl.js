angular.module('mainModule').controller('animalEditCtrl', ['$scope','$uibModalInstance','toastr','foodFactory','animalFactory','animalEditInfo','$window', function($scope, $uibModalInstance, toastr, foodFactory, animalFactory, animalEditInfo, $window){

	$scope.animal = {};
	$scope.animal.animalName = "";
	$scope.animal.scientificName = "";
	$scope.animal.informationalLink = "";
	$scope.foods = [];
	$scope.favoriteFood = {};
	
	$scope.animal.animalName = animalEditInfo.animalName;
	$scope.animal.scientificName = animalEditInfo.scientificName;
	$scope.favoriteFood = animalEditInfo.favoriteFood;
	$scope.animal.informationalLink = animalEditInfo.informationalLink;
	
	var foodData = foodFactory.getAllFoods().then(
			function(success){
				$scope.foods = success.data;
			}
	)
	
	$scope.foodSettings = {externalIdProp: 'favoriteFoodId', displayProp: 'favoriteFoodName', idProp: 'favoriteFoodId', smartButtonMaxItems: 1, selectionLimit: 1};
	$scope.foodText = {buttonDefaultText: 'Select Food'};
	
	
	$scope.editAnimal = function(animal, favoriteFood){
		if($scope.validateAnimal(animal, favoriteFood)){
			animal.animalId = animalEditInfo.animalId;
			animal.favoriteFood = favoriteFood;
			animalFactory.addAnimal(animal).then(
					function(success){
						$window.location.reload();
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