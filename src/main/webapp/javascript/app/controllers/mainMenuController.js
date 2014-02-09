/**
 * Created by jiabin on 14-1-27.
 */
myApp.controller('mainMenuController',function($scope){
    $scope.mainMenu=[];
    var menuItem_travel={
        displayName:"travel",
        isActive:false,
        children:[]
    }
    var child1={
        displayName:"travelChild1",
        isActive:false,
        children:[]
    }
    var child2={
        displayName:"travelChild2",
        isActive:false,
        children:[]
    }
    var child3={
        displayName:"articleChild1",
        isActive:false,
        children:[]
    }
    var child4={
        displayName:"articleChild2",
        isActive:false,
        children:[]
    }
    var menuItem_article={
        displayName:"article",
        isActive:false,
        children:[]
    }
    menuItem_travel.children.push(child1);
    menuItem_travel.children.push(child2);
    menuItem_article.children.push(child3);
    menuItem_article.children.push(child4);
    $scope.mainMenu.push(menuItem_travel);
    $scope.mainMenu.push(menuItem_article);



    $scope.openMenu=function(item,parent){
        if( !item.isActive){
            for(key in parent){
                parent[key].isActive=false;
            }
            item.isActive=true;
        }else{
            item.isActive=false;
        }

    }
});
