function formatNumber(num) {
    return ' R$ ' + num.toFixed(2).replace('.', ',').replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1.');
}

document.addEventListener('DOMContentLoaded', function() {
    var elements = document.getElementsByClassName('valor-reais-exb');
    for(var i = 0; i < elements.length; i++) {
        elements[i].textContent = formatNumber(parseFloat(elements[i].textContent));
    }
});