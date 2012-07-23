function formatCurrency(textField) {
    var positionCaretStart = textField.caret().start;
    var positionCaretEnd = textField.caret().stop;
    var positionCaret;
    if (positionCaretStart > positionCaretEnd) {
        positionCaret = positionCaretEnd;
    }  else {
        positionCaret = positionCaretStart;
    }
    var lengthBefore = textField.val().toString().length;
    if(textField.val().toString().indexOf(",") < 0 ) {
        lengthBefore += 3;
    }
    if (!(textField.val().toString().indexOf(",") < 0) && textField.val().toString().indexOf(",") < (positionCaret - 1)) {
        lengthBefore -= 1;
    }
    textField.formatCurrency({decimalSymbol:',', digitGroupSymbol:' ', symbol:' '});
    var lengthAfter = textField.val().toString().length;
    positionCaret += (lengthAfter - lengthBefore);
    textField.caret({start : positionCaret,end : positionCaret});  
}