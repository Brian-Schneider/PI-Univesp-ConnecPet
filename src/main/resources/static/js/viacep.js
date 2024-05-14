document.getElementById('cep').addEventListener('blur', function() {
    var cep = this.value.replace(/\D/g, '');

    if (cep != "") {
        var validacep = /^[0-9]{8}$/;

        if(validacep.test(cep)) {
            fetch(`https://viacep.com.br/ws/${cep}/json/`)
                .then(response => response.json())
                .then(data => {
                    if (!("erro" in data)) {
                        document.getElementById('endereco').value = data.logradouro;
                        document.getElementById('cidade').value = data.localidade;
                        document.getElementById('estado').value = data.uf;
                        document.getElementById('bairro').value = data.bairro;
                    } else {
                        alert("CEP não encontrado.");
                    }
                })
                .catch((error) => {
                    console.error(error);
                    alert("Erro quando consultando CEP.");
                });
        } else {
            alert("Formato inválido de CEP");
        }
    }
});