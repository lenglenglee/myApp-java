myApp.controller('talksController',
    function($scope, socket,$sce) {
        $scope.talks = [];
        $scope.testimg='../images/IMG_0425.JPG';
        $scope.testtext="not start";
        socket.onmessage=function(e){
        	$scope.testtext="complie";
        	console.log(e);
        	if(typeof(e.data )=="string"){
        		var nowTime = new Date();
        		nowTime = nowTime.Format("yyyy-MM-dd hh:mm:ss");
        		var data={
        				img: '../images/headimage.jpg',
                        name: $scope.user,
                        time: nowTime,
                        content: e.data
        		}
        		$scope.talks.push(data);
        		$scope.$apply();
        	}else{
        		var url=window.URL.createObjectURL(e.data);
            	
            	//document.getElementById("test").src=url;
            	$sce.trustAsResourceUrl(url);
            	$scope.testimg=url;
            	$scope.$apply();
        	}
//        	
        	
        	
        }

        $scope.sendMsg = function() {
        	 $scope.testtext="loading....";
            if ($scope.msg != "" && $scope.msg != null) {
                var nowTime = new Date();
                nowTime = nowTime.Format("yyyy-MM-dd hh:mm:ss");
                var data = {
                    'data': {
                        img: '../images/headimage.jpg',
                        name: $scope.user,
                        time: nowTime,
                        content: $scope.msg
                    }
                }
                socket.send(JSON.stringify(data));
                $scope.msg = "";
            } else {
                alert("the message can not be null!!");
            }

        }


    }
);