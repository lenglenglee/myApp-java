myApp.filter('trustedResource', ['$sce', function($sce) {
    return function(val) {
        return $sce.getTrustedResourceUrl(val);
    };
}])