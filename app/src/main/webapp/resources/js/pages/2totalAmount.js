//ewentualnie można dodać klasę np. .currencyInput
$(function() {
    $('[id="formTotal:amount"]').bind('keyup', function() {
        formatCurrency($(this));
    });
})
