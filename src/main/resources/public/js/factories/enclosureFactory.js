angular.module('mainModule').factory('enclosureFactory', ['$http', function($http){
    return{
        getEnclosureConditions : function(){
            return $http.get("/enclosureCondition");
        },
        addAnimalEnclosure : function(enclosure){
            return $http.post("/animalEnclosure", enclosure);
        }
    }
}]);