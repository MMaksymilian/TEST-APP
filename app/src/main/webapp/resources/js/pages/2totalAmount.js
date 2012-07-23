$(function() {
    $('[id="formTotal:amount"]').bind('keyup', function() {
        formatCurrency($(this));
    });
})
