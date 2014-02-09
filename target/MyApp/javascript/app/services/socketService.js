myApp.factory('socket', function($rootScope) {
    var webSocket =new WebSocket('ws://localhost:8080/MyApp/chat');
    return webSocket;
});