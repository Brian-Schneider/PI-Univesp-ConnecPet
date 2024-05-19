document.querySelector('form').addEventListener('submit', function(e) {

    var checkboxes = document.querySelectorAll('input[type=checkbox]');

    var checkedValues = [];

    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
            checkedValues.push(checkbox.value);
        }
    });
});