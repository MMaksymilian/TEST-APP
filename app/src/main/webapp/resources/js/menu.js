var menuItemId = '<h:outputText value="#{pageController.chosenId}"/>';
$(function() {
    $('[id*="' + menuItemId + '"]').css('background-color', 'grey');
});