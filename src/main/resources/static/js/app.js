var app = angular.module('hello', []);

app.controller('home', function($scope, httpService) {
    $scope.results = [];

    function setGreeting(response) {
        $scope.results = response.data;
        for (var i= 0; i < $scope.results.length; i++){
            console.log($scope.results[i]);
        }
    }
    $scope.sendMessage = function(){
        console.log($scope.query)
        httpService.doQuery($scope.query, setGreeting);
    }
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


