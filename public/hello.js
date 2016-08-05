/**
 * 
 */
function Hello($scope, $http) {
	http://localhost:8080/user?name=Rob&userId=POCOID').
        success(function(data) {
            $scope.user = data;
        });
}