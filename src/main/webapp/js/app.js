var app = angular.module("MyApp", [ 'ui.router' ]);
app.config([ '$stateProvider', '$urlRouterProvider',"$locationProvider", 
		function($stateProvider, $urlRouterProvider,$locationProvider) {

			$stateProvider.state('search', {
				url : "/search",
				templateUrl : 'views/search.html',
				controller : "PurchaseController"

			});

			$stateProvider.state('customers', {
				url : "/customer/list",
				templateUrl : 'views/customer/list.html',
				controller : "CustomerController"
			});

			$urlRouterProvider.otherwise("/home");
			$locationProvider.html5Mode(true);

		} ]);

app.controller("PurchaseController", function($scope, $http) {

	$scope.pagePurchases = null;
	$scope.min = 0;
	$scope.max = 0;
	$scope.currentPage = 0;
	$scope.size = 4;
	$scope.pages = [];

	$scope.searchPurchases = function() {

		$http.get(
				"http://localhost:8080/searchPurchases?max=" + $scope.max
						+ "&min=" + $scope.min + "&page=" + $scope.currentPage
						+ "&size=" + $scope.size).then(function(response) {
			$scope.pagePurchases = response.data;
			$scope.pages = new Array(response.data.totalPages)

		}, function(response) {
			console.log(response.data);
		});
	}

	$scope.getPurchase = function() {
		$scope.currentPage = 0;
		$scope.searchPurchases();

	}
	$scope.goToPage = function(p) {
		$scope.currentPage = p;
		$scope.searchPurchases();
	}

	$scope.myFunc = function() {
		$scope.showMe = !$scope.showMe;
	}

	$scope.init = function() {
		$http.get(
				"http://localhost:8080/searchPurchases?max=" + 50000
						+ "&min=" + 0 + "&page=" + $scope.currentPage
						+ "&size=" + $scope.size).then(function(response) {
			$scope.pagePurchases = response.data;
			$scope.pages = new Array(response.data.totalPages)

		}, function(response) {
			console.log(response.data);
		});
	}
});

app.controller("CustomerController", function($scope, $http) {

	$scope.pageCustomers = null;
	$scope.pagePurchases = null;
	$scope.currentPageCustomer = 0;
	$scope.currentPagePurchase = 0;
	$scope.size = 4;
	$scope.pagesCustomer = [];
	$scope.pagesPurchase = [];
	$scope.display = 0;

	$scope.displayCustomers = function() {

		$http.get(
				"http://localhost:8080/customer/list?page="
						+ $scope.currentPageCustomer + "&size=" + $scope.size)
				.then(function(response) {
					$scope.pageCustomers = response.data;
					$scope.pagesCustomer = new Array(response.data.totalPages)

				}, function(response) {
					console.log(response.data);
				});
	}

	$scope.goToPageCustomer = function(p) {
		$scope.currentPageCustomer = p;
		$scope.displayCustomers();
	}

	$scope.showPurchases = function(idCustomer) {
		$scope.display = 1;
		$http.get(
				"http://localhost:8080/customer/purchases/" + idCustomer
						+ "?page=" + $scope.currentPagePurchase + "&size="
						+ $scope.size).then(function(response) {
			$scope.pagePurchases = response.data;
			$scope.pagesPurchase = new Array(response.data.totalPages)
		}, function(response) {
			console.log(response.data);
		});

	}

	$scope.goToPagePurchase = function(p) {
		$scope.currentPagePurchase = p;
		$scope.showPurchases();
	}

});