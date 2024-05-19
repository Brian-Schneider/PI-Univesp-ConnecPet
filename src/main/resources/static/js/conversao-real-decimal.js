function formatAsCurrency(field) {
    var value = parseFloat(field.value);
    if (!isNaN(value)) {
        field.value = new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(value);
    } else {
        field.value = '';
    }
}

var valorReaisInputs = document.querySelectorAll('.valor-reais');

Array.from(valorReaisInputs).forEach(function(valorReaisInput) {
    var originalValue = valorReaisInput.value;
    var isFirstFocus = true;

    valorReaisInput.addEventListener('focus', function(e) {
        if (isFirstFocus) {
            valorReaisInput.value = '';
            isFirstFocus = false;
        }
    });

    valorReaisInput.addEventListener('blur', function(e) {
        formatAsCurrency(valorReaisInput);
    });
});

document.querySelector('form').addEventListener('submit', function(e) {
    e.preventDefault();  // Prevent default form submission

    Array.from(valorReaisInputs).forEach(function(valorReaisInput) {
        var valorReais = valorReaisInput.value.replace(/\./g, '').replace(/,/g, '.').replace(/R\$/g, '').trim();
        if (isNaN(parseFloat(valorReais))) {
            alert('Favor, inserir um valor válido para a hora do passeio.');
            return;
        }

        valorReaisInput.value = parseFloat(valorReais.replace(/,/g, '.'));
    });

    e.target.submit();  // Manually submit the form
});

// Create a MutationObserver to watch for changes in the input fields
var observer = new MutationObserver(function(mutations) {
    mutations.forEach(function(mutation) {
        // If the value of the input field has changed, format it as currency
        if (mutation.type === 'attributes' && mutation.attributeName === 'value') {
            formatAsCurrency(mutation.target);
        }
    });
});

// Start observing each input field for attribute changes
valorReaisInputs.forEach(function(input) {
    observer.observe(input, { attributes: true });
});

