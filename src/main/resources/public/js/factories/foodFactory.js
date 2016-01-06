angular.module('mainModule').factory('foodFactory', ['$http', function($http){
    return{
        getAllFoods : function(){
            return $http.get("/food");
        },
    }
}]);