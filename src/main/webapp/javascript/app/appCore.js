var myApp = angular.module("myApp", ['ngSanitize']);



myApp.config(function($compileProvider) {
	$compileProvider.imgSrcSanitizationWhitelist(/^\s*(https?|ftp|file|blob):|data:image\//);
});