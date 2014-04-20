window._originalAlert = window.alert;
window.alert = function(text) {
	bootbox.alert(text, function() {
        console.log("Alert Callback");
    });
}
window._originalConfirm = window.confirm;
console.log(window._originalConfirm);
window.confirm = function(text) {
	
	bootbox.confirm(text, function(result) {
        rr=true;
        result1=result;
    });
	return window._originalConfirm(text);
}