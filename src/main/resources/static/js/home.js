$(document).ready(function () {
    $("#query").on('click',function(message){
        window.location.href='/transaction';
        return false;
    });

    $("#transfer").on('click',function(message){
        window.location.href='/transfer';
        return false;
    });
});