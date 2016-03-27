angular.module('app.controllers', [])
.controller('HomeController', function($scope, Location) {
    L.mapbox.accessToken = 'pk.eyJ1IjoiY3BkbGF0bSIsImEiOiJjaWxkZTR1bjgwZWMzdmFtYzd4ajhjcjRnIn0.-y57DqhBHm0jg2-v1JI-UQ';
    var map = L.mapbox.map('map', 'mapbox.streets')
        .setView([0, 0], 1);
    Location.query().$promise.then(
        function(locations) {
            for(var i = 0; i < locations.length; i++) {
                L.marker([locations[i].latitude,locations[i].longitude]).addTo(map);
            }
        }
    );


})

.controller('LocationListController', function($scope, $state, popupService, $window, Location) {
    $scope.locations = Location.query(); //fetch all locations. Issues a GET to /api/vi/locations

    $scope.deleteLocation = function(location) { // Delete a Location. Issues a DELETE to /api/v1/locations/:id
    if (popupService.showPopup('Really delete this?')) {
        location.$delete(function() {
            $scope.locations = Location.query();
            $state.go('locations');
        });
        }
    };
})

.controller('LocationViewController', function($scope, $stateParams, Location) {
  $scope.location = Location.get({ id: $stateParams.id }); //Get a single location.Issues a GET to /api/v1/locations/:id
})

.controller('LocationCreateController', function($scope, $state, $stateParams, Location) {
  $scope.location = new Location();  //create new location instance. Properties will be set via ng-model on UI

  $scope.addLocation = function() { //create a new location. Issues a POST to /api/v1/locations
    $scope.location.$save(function() {
      $state.go('locations'); // on success go back to the list i.e. locations state.
    });
  };
})

.controller('LocationEditController', function($scope, $state, $stateParams, Location) {
  $scope.updateLocation = function() { //Update the edited location. Issues a PUT to /api/v1/locations/:id
    $scope.location.$update(function() {
      $state.go('locations'); // on success go back to the list i.e. locations state.
    });
  };

  $scope.loadLocation = function() { //Issues a GET request to /api/v1/locations/:id to get a location to update
    $scope.location = Location.get({ id: $stateParams.id });
  };

  $scope.loadLocation(); // Load a location which can be edited on UI
});
