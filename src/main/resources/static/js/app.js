var app = angular.module('hello', []);

app.controller('home', function($scope, httpService) {

    function setGreeting(response) {
        var results = response.data;
        for (var i= 0; i < results.length; i++){
            console.log(results[i]);
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


