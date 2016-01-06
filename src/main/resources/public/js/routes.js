'use strict';

angular.module('mainModule').config(['$stateProvider','$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    $urlRouterProvider.otherwise('/');
    
    $stateProvider.state('viewAllEnclosures',{
        url: '/viewEnclosures',
        templateUrl: 'templates/viewAllEnclosures.tpl.html',
        controller: 'viewAllEnclosuresCtrl'
    })
    .state('viewSingleEnclosure',{
        url: '/viewEnclosure/{id}',
        templateUrl: 'templates/viewSingleEnclosure.tpl.html',
        controller: 'viewSingleEnclosureCtrl',
        resolve: {
        	enclosureInfo : function($stateParams, enclosureFactory){
        		return enclosureFactory.getEnclosureById($stateParams.id);
        	}
        }
    })
    .state('home',{
    	url: '/',
        templateUrl: 'templates/home.tpl.html',
        controller: 'homeCtrl'
    })
    .state('viewAllAnimals',{
    	url: '/viewAnimals',
        templateUrl: 'templates/viewAllAnimals.tpl.html',
        controller: 'viewAnimalsCtrl'
    })
    .state('viewSingleAnimal',{
    	url: '/viewAnimal/{id}',
        templateUrl: 'templates/viewSingleAnimal.tpl.html',
        controller: 'viewSingleAnimalCtrl',
        resolve: {
        	animalInfo : function($stateParams, animalFactory){
        		return animalFactory.getAnimalById($stateParams.id);
        	}
        }
    })
}])