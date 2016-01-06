angular.module('mainModule').controller('addEnclosureCtrl', ['$scope', '$filter', '$uibModalInstance','toastr', 'enclosureFactory', 'animalFactory', function($scope, $filter, $uibModalInstance, toastr, enclosureFactory, animalFactory){

	$scope.hstep = 1;
    $scope.mstep = 5;
    $scope.enclosureCondition = {};
    $scope.enclosure = {};
    $scope.enclosureAnimal = {};
    $scope.existingConditions = true;
    $scope.feedingTime = new Date();
    $scope.feedingTime.setHours(0);
    $scope.feedingTime.setMinutes(0);
    $scope.ismeridian = true;
    
    //Settings for DropDowns
    $scope.enclosureConditionSettings = {externalIdProp: '', displayProp: 'enclosureCondition', idProp: 'enclosureConditionId', smartButtonMaxItems: 1, selectionLimit: 1};
    $scope.animalSettings = {externalIdProp: 'animalId', displayProp: 'animalName', idProp: 'animalId', smartButtonMaxItems: 1, selectionLimit: 1};
    
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
        feedingTime.setSeconds(0);
        feedingTime.setMilliseconds(0);
        var feedingTimeJson = feedingTime.getTime();
        $scope.enclosure.feedingTime = {};
        $scope.enclosure.feedingTime = feedingTimeJson;
        
        $scope.enclosure.animal = enclosureAnimal;
        $scope.enclosure.enclosureCondition = {};
        $scope.enclosure.enclosureCondition = enclosureCondition;
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
	
	$scope.closeModal = function(){
		$uibModalInstance.close();
	}
    
     $scope.changeBoolean = function(){
        $scope.show = !$scope.show;
     }
     
}])
