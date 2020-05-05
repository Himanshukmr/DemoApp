var app = angular.module("myApp", []);
app.controller("myController", function($http, $scope) {

	$scope.animals = [];

	$scope.form = {
	/*
	 * type : "", name : "", gender : "", specie : ""
	 */

	};
	

	$scope.init = function() {

		$scope.animalGender = [ 'male', 'female' ];

		$http({
			method : 'GET',
			url : 'http://localhost:8085/animal'
		}).then(function successCallback(response) {

			$scope.listOfType = response.data;

		}, function errorCallback(response) {
			console.log(response.statusText);

		});
	}

	$scope.isVisibleAdd = false;
	$scope.showHideAdd = function() {
		$scope.isVisibleAdd = $scope.isVisibleAdd ? false : true;
		$scope.isVisibleAnimal = false;
		$scope.isVisibleAnimalcount = false;
	}

	$scope.isVisibleAnimal = false;
	$scope.viewAllAnimal = function() {
		$scope.isVisibleAnimal = $scope.isVisibleAnimal ? false : true;
		$scope.isVisibleAdd = false;
		$scope.isVisibleAnimalcount = false;

		$http({
			method : 'GET',
			url : 'http://localhost:8085/allAnimal'
		}).then(function successCallback(response) {
			$scope.animals = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	}

	$scope.isVisibleAnimalcount = false;
	$scope.viewAnimalCount = function() {
		$scope.isVisibleAnimalcount = $scope.isVisibleAnimalcount ? false
				: true;
		$scope.isVisibleAdd = false;
		$scope.isVisibleAnimal = false;

		$http({
			method : 'GET',
			url : 'http://localhost:8085/allAnimal'
		}).then(function successCallback(response) {
			$scope.totalCount = response.data.length;
			$scope.totalAnimalInZoo = response.data;
		}, function errorCallback(response) {
			console.log(response.statusText);
		});

	}

	$scope.getSpecie = function() {

		$http({
			method : 'GET',
			url : 'http://localhost:8085/animal/' + $scope.form.type
		}).then(function successCallback(response) {

			$scope.listOfSpecie = response.data;

		}, function errorCallback(response) {
			console.log(response.data);

		});

	}

	$scope.addAnimal = function() {

		if ($scope.form.name == undefined
				|| $scope.form.name.trim().length == 0) {
			alert("name can not be blank");
			return false;
		}

		$http({
			method : 'POST',
			url : 'http://localhost:8085/animal',
			data : angular.toJson($scope.form),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.msg = response.data.statusMsg;
		}, function errorCallback(response) {
			console.log(response.data);

		});
	}

	$scope.getdetails = function(selectedChkBox) {
		$scope.searchColumnName = selectedChkBox;
	}

	// delete row from table
	$scope.deleteRow = function(id) {

		$http({
			method : 'DELETE',
			url : 'http://localhost:8085/animal/' + id
		}).then(function successCallback(response) {
			$scope.animals = response.data;
		}, function errorCallback(response) {
			console.log(response.data);

		});

	}

})