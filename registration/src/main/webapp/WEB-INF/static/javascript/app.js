var app = angular.module('AcmeRegistration', [])
	.config(['$httpProvider', function ($httpProvider) {
		$httpProvider.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
		$httpProvider.defaults.transformRequest.unshift(function (data, headersGetter) {
			var key, result = [];
			for (key in data) {
				if (data.hasOwnProperty(key)) {
					result.push(encodeURIComponent(key) + "=" + encodeURIComponent(data[key]));
				}
			}
			return result.join("&");
		});
	}])
	.factory('MembersRepository', ['$http', function($http) {
		var members = [];

		function update() {
			$http.get('/registration/members').success(function (users) {
				members.length = 0;
				if (users) {
					users.forEach(function(u) {members.push(u);});
				}
			});
		};

		return {
			members: members,
			update: update
		};
	}]);

app.controller('MembersController', ['$scope', '$http', 'MembersRepository', function ($scope, $http, MembersRepository) {
	$scope.repository = MembersRepository;
	$scope.repository.update();
}]);

app.controller('RegistrationController', ['$scope', '$http', 'MembersRepository', function ($scope, $http, MembersRepository) {
	$scope.repository = MembersRepository;

	$scope.member = {};

	$scope.register = function () {
		$http.post('/registration/new', $scope.member).success(function () {
			$scope.repository.update();
		});
	}


}]);
