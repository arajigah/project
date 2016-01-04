angular.module('mainModule').controller('addEnclosureCtrl', ['$scope', '$filter', '$uibModalInstance','toastr', 'enclosureFactory', function($scope, $filter, $uibModalInstance, toastr, enclosureFactory){

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
    
    
    
    $scope.enclosureConditionSettings = {externalIdProp: '', displayProp: 'enclosureCondition', idProp: 'enclosureConditionId', smartButtonMaxItems: 1, selectionLimit: 1};

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
    
    $scope.addEnclosure = function(enclosure, feedingTime, enclosureCondition){
        feedingTime.setSeconds(0);
        feedingTime.setMilliseconds(0);
        var feedingTimeJson = feedingTime.getTime();
        $scope.enclosure.feedingTime = {};
        $scope.enclosure.feedingTime = feedingTimeJson;
        $scope.enclosure.enclosureCondition = {};
        $scope.enclosure.enclosureCondition = enclosureCondition;
        enclosureFactory.addAnimalEnclosure(enclosure).then(
            function(success){
                console.log(success.data);
                $scope.closeModal();
                toastr.success('woohoo','Success');
            },
            function(error){
                console.log(error);
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
