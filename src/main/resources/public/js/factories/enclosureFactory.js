angular.module('mainModule').factory('enclosureFactory', ['$http', function($http){
    return{
        getEnclosureConditions : function(){
            return $http.get("/enclosureCondition");
        },
        addAnimalEnclosure : function(enclosure){
            return $http.post("/animalEnclosure", enclosure);
        },
        getAllEnclosures : function(){
        	return $http.get("/animalEnclosure");
        },
        getEnclosureById : function(enclosureId){
        	return $http.get("/animalEnclosure/" + enclosureId)
        },
        editAnimalEnclosure : function(enclosure){
            return $http.post("/animalEnclosure", enclosure);
        },
        deleteEnclosure : function(enclosureId){
        	return $http.delete("/animalEnclosure/" + enclosureId);
        }
    }
}]);