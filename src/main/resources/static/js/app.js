var app = angular.module('app', []);

app.controller('home', function($scope, httpService) {
    $scope.results = [];

    function setResults(response) {
        $scope.results = response.data;
        for (var i= 0; i < $scope.results.length; i++){
            console.log($scope.results[i]);
        }
    }
    function doQuery(){
        if ($scope.query) {
            console.log($scope.query)
            httpService.doQuery($scope.query, setResults);
        }
    }
    $scope.$watch("query", function() {
        doQuery();
    }, true);


});

app.factory('httpService', function($http){
    return {
        doQuery : function(query, callback){
            $http({
                method: 'POST',
                url: '/search',
                data: query
            }).then(callback);
        }
    };
});


