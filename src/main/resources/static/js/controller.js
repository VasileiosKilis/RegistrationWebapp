app
		.controller(
				'listController',
				function($scope, $http, $location, $route) {

					$http({
						method : 'GET',
						url : 'http://localhost:8282/api/user/'
					}).then(function(response) {
						$scope.users = response.data;
					});

					$scope.editUser = function(userId) {
						$location.path("/update-user/" + userId);
					}

					$scope.deleteUser = function(userId) {
						$http({
							method : 'DELETE',
							url : 'http://localhost:8282/api/user/' + userId
						})
								.then(
										function(response) {
											$location.path("/listofusers");
											$route.reload();
										});
					}
				});

app.controller('registerController', function($scope, $http, $location,
		$route) {

	$scope.submitUserForm = function() {
		$http({
			method : 'POST',
			url : 'http://localhost:8282/api/user/',
			data : $scope.user,
		}).then(function(response) {
			$location.path("/listofusers");
			$route.reload();
		}, function(errResponse) {
			$scope.errorMessage = errResponse.data.errorMessage;
		});
	}

	$scope.resetForm = function() {
		$scope.user = null;
	};
});

app
		.controller(
				'updateController',
				function($scope, $http, $location, $routeParams, $route) {

					$scope.userId = $routeParams.id;

					$http({
						method : 'GET',
						url : 'http://localhost:8282/api/user/' + $scope.userId
					}).then(function(response) {
						$scope.user = response.data;
					});

					$scope.submitUserForm = function() {
						$http({
							method : 'POST',
							url : 'http://localhost:8282/api/user/',
							data : $scope.user,
						})
								.then(
										function(response) {
											$location.path("/listofusers");
											$route.reload();
										},
										function(errResponse) {
											$scope.errorMessage = "Error while updating User - Error Message: '"
													+ errResponse.data.errorMessage;
										});
					}
				});