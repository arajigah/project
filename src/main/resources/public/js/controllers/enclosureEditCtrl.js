angular.module('mainModule').controller('enclosureEditCtrl', ['$scope', '$filter', '$uibModalInstance','toastr', 'enclosureFactory', 'animalFactory', 'enclosureEditInfo','toastr', function($scope, $filter, $uibModalInstance, toastr, enclosureFactory, animalFactory, enclosureEditInfo, toastr){

	$scope.hstep = 1;
    $scope.mstep = 5;
    $scope.enclosureCondition = {};
    $scope.enclosure = {};
    $scope.enclosureAnimal = {};
    $scope.existingConditions = true;
    $scope.feedingTime = new Date();
    $scope.ismeridian = true;
    
    $scope.enclosure.animalEnclosureName = enclosureEditInfo.data.animalEnclosureName;
    $scope.enclosure.numberOfAnimals = enclosureEditInfo.data.numberOfAnimals;
    $scope.enclosureAnimal = enclosureEditInfo.data.animal;
    
    var timeArray = enclosureEditInfo.data.feedingTime.match(/(\d+)\:(\d+) (\w+)/);    
    if(timeArray[3] === "PM"){
    	var hours = parseInt(timeArray[1]) + 12;
    	$scope.feedingTime.setHours(hours);
    }
    else{
    	$scope.feedingTime.setHours(timeArray[1]);
    }
    $scope.feedingTime.setMinutes(timeArray[2]);
    
    $scope.enclosureCondition = enclosureEditInfo.data.enclosureCondition;
    
    
    
    $scope.enclosureConditionSettings = {externalIdProp: '', displayProp: 'enclosureCondition', idProp: 'enclosureConditionId', smartButtonMaxItems: 1, selectionLimit: 1};
    $scope.animalSettings = {externalIdProp: 'animalId', displayProp: 'animalName', idProp: 'animalId', smartButtonMaxItems: 1, selectionLimit: 1};
    
    
    var conditionData = enclosureFactory.getEnclosureConditions().then(
        function(success){
            $scope.enclosureConditions = success.data;
        },
        function(error){
        	$scope.enclosureConditions = error;
        }
    )
    var animalData = animalFactory.getAnimals().then(
        function(success){
            $scope.animals = success.data;
        },
        function(error){
        $scope.enclosureConditions = error;
        }
    )
    
    $scope.editEnclosure = function(enclosure, feedingTime, enclosureCondition, enclosureAnimal){
    	$scope.enclosure.animalEnclosureId = enclosureEditInfo.data.animalEnclosureId;
        feedingTime.setSeconds(0);
        feedingTime.setMilliseconds(0);
        var feedingTimeJson = feedingTime.getTime();
        $scope.enclosure.feedingTime = {};
        $scope.enclosure.feedingTime = feedingTimeJson;
        
        $scope.enclosure.animal = enclosureAnimal;
        $scope.enclosure.enclosureCondition = {};
        $scope.enclosure.enclosureCondition = enclosureCondition;
        enclosureFactory.editAnimalEnclosure(enclosure).then(
            function(success){
                console.log(success.data);
                $scope.closeModal();
                toastr.success('Enclosure was edited successfully');
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