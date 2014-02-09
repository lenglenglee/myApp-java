myApp.filter("crlfFilter", function() {
    var filterName = function(content) {
        return content.replace(/\n/g, "<br />");
    }
    return filterName
});