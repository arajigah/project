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
    }).state('home',{
    	url: '/',
        templateUrl: 'templates/home.tpl.html',
        controller: 'homeCtrl'
    })
}])