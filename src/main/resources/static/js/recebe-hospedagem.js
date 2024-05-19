
function toggleFields() {
    var hospedagemChecked = document.getElementById('hospedagem').checked;
    document.getElementById('petsHospedados').style.display = hospedagemChecked ? 'block' : 'none';
    document.getElementById('limitePetsHospedados').style.display = hospedagemChecked ? 'block' : 'none';
    document.getElementById('descricaoLocacao').style.display = hospedagemChecked ? 'block' : 'none';
}

document.addEventListener('DOMContentLoaded', function() {
    toggleFields();
});