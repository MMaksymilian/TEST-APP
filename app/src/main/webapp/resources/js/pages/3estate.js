//ewentualnie można dodać klasę np. .currencyInput
function callbackFunctionToSetFormattingCurrency(){
    $('[id="estateDialog:mainValue"]').bind('keyup', function() {
        formatCurrency($(this));
    });
    $('[id="estateDialog:addChildValue"]').bind('keyup', function() {
        formatCurrency($(this));
    });
}
function showAddPanel() {
    $('[id="estateDialog:addPanel"]').show('slow');
}