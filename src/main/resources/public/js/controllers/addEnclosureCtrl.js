angular.module('mainModule').controller('addEnclosureCtrl', ['$scope', '$filter', '$uibModalInstance','toastr', 'enclosureFactory', 'animalFactory', function($scope, $filter, $uibModalInstance, toastr, enclosureFactory, animalFactory){

	$scope.hstep = 1;
    $scope.mstep = 5;
    $scope.enclosureCondition = {};
    //$scope.enclosureCondition.enclosureCondition = "";
    $scope.enclosure = {};
    $scope.enclosure.animalEnclosureName = "";
    $scope.enclosure.numberOfAnimals = "";
    $scope.enclosureAnimal = {};
    $scope.existingConditions = true;
    $scope.feedingTime = new Date();
    $scope.feedingTime.setHours(0);
    $scope.feedingTime.setMinutes(0);
    $scope.ismeridian = true;
    $scope.enclosureConditionInput = "";
    
    //Settings for DropDowns
    $scope.enclosureConditionSettings = {externalIdProp: '', displayProp: 'enclosureCondition', idProp: 'enclosureConditionId', smartButtonMaxItems: 1, selectionLimit: 1};
    $scope.animalSettings = {externalIdProp: 'animalId', displayProp: 'animalName', idProp: 'animalId', smartButtonMaxItems: 1, selectionLimit: 1};
    $scope.conditionText = {buttonDefaultText: 'Select Condition'};
    $scope.animalText = {buttonDefaultText: 'Select Animal'};
    
    $scope.conditionData = enclosureFactory.getEnclosureConditions().then(
        function(success){
            $scope.enclosureConditions = success.data;
            if($scope.enclosureConditions.length == 0){
                $scope.show = true;
                $scope.existingConditions = false;
            }
        },
        function(error){
        $scope.enclosureConditions = error;
        }
    )
    
    $scope.animalData = animalFactory.getAnimals().then(
        function(success){
            $scope.animals = success.data;
        },
        function(error){
        $scope.enclosureConditions = error;
        }
    )
    
    $scope.addEnclosure = function(enclosure, feedingTime, enclosureCondition, enclosureAnimal){
    	$scope.enclosure.enclosureCondition = {};
    	if($scope.enclosureConditionInput != ""){
    		$scope.enclosure.enclosureCondition.enclosureCondition = $scope.enclosureConditionInput;
    	}
    	else{
            $scope.enclosure.enclosureCondition = enclosureCondition;
    	}
        feedingTime.setSeconds(0);
        feedingTime.setMilliseconds(0);
        var feedingTimeJson = feedingTime.getTime();
        $scope.enclosure.feedingTime = {};
        $scope.enclosure.feedingTime = feedingTimeJson;
        $scope.enclosure.animal = enclosureAnimal;
        
        if($scope.validateEnclosure(enclosure)){
	        enclosureFactory.addAnimalEnclosure(enclosure).then(
	            function(success){
	                $scope.closeModal();
	                toastr.success('Enclosure was added successfully');
	            },
	            function(error){
	            	if(error.status == 500){
	            		toastr.error('All Fiels Are Required','The Enclosure was not valid');
	            	}
	            }
	        )
        }
    }
	
	$scope.closeModal = function(){
		$uibModalInstance.close();
	}
    
     $scope.changeBoolean = function(){
    	$scope.enclosureConditionInput = "";
        $scope.show = !$scope.show;
     }
     
     $scope.validateEnclosure = function(enclosure){
    	 var result = true;
    	 var name = enclosure.animalEnclosureName.trim();
    	 var animal = enclosure.animal.animalId;
    	 var condition = enclosure.enclosureCondition.enclosureCondition;
    	 var numberOfAnimals = enclosure.numberOfAnimals;
    	 console.log(enclosure);
    	 
    	 if(typeof animal === 'undefined'){
 			result = false;
 			toastr.error("Animal is Required");
 		}
 		if(name == ""){
 			result = false;
 			toastr.error("Enclosure Name is Required");
 		}
 		if(typeof condition === 'undefined'){
 			result = false;
 			toastr.error("Enclosure Condition is Required");
 		}
 		if(numberOfAnimals == 0 || numberOfAnimals == "" || numberOfAnimals == null){
 			result = false;
 			toastr.error("You Must Have Animals In The Enclosure");
 		}
 		return result;
 	}
     
     
     
}])
