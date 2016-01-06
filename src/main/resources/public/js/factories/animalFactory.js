angular.module('mainModule').factory('animalFactory', ['$http', function($http){
    return{
        getAnimals : function(){
            return $http.get("/animal");
        },
        addAnimal : function(animal){
        	return $http.post("/animal", animal);
        }
    }
}]);