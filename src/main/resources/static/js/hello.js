angular.module('hello', [])
  .controller('home', function($http) {
  var rootContext = '/interchat';
  var self = this;
  $http.get(rootContext + '/rest/resource/').success(function(data) {
    self.greeting = data;
  })
});