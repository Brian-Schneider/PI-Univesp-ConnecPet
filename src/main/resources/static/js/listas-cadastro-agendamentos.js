
$(document).ready(function() {
    // Call loadClientes() when the page loads
    // Initially disable the "Pets" and "Prestador" dropdowns
    loadClientes();
    $('#pet').prop('disabled', true);
    $('#prestador').prop('disabled', true);

    // Add default options to the "Pets" and "Prestador" dropdowns
    $('#pet').append(new Option("--SELECIONE UM PET--", "", true, true));
    $('#servico').prepend(new Option("--SELECIONE UM SERVIÇO--", "", true, true));
    $('#prestador').append(new Option("--SELECIONE UM PRESTADOR--", "", true, true));


    $('#cliente').change(function() {
        // If a valid client is selected, enable the "Pets" dropdown
        if ($(this).val() !== "") {
            $('#pet').prop('disabled', false);
            loadPets();
        } else {
            $('#pet').prop('disabled', true);
        }
    });

    $('#servico').change(function() {
        if ($(this).val() !== "") {
            $('#prestador').prop('disabled', false);
            loadPrestadores();
        } else {
            $('#prestador').prop('disabled', true);
        }
    });
});

function loadClientes() {
    var clienteSelect = $('#cliente');
    clienteSelect.empty();
    clienteSelect.append(new Option("--SELECIONE UM CLIENTE--", "", true, true));

    // Return the AJAX promise
    return $.ajax({
        url: '/agendamentos/clientes', // Replace with your actual endpoint
        type: 'GET',
        success: function(clientes) {
            $.each(clientes, function(index, cliente) {
                clienteSelect.append(new Option(cliente.primeiroNome + ' ' + cliente.sobrenome, cliente.id));
            });
        }
    });
}

function loadPets() {
    var idCliente = $('#cliente').val();
    $.ajax({
        url: '/agendamentos/pets/' + idCliente,
        type: 'GET',
        success: function(pets) {
            var petSelect = $('#pet');
            petSelect.empty();
            petSelect.append(new Option("--SELECIONE UM PET--", "", true, true));

            $.each(pets, function(index, pet) {
                petSelect.append(new Option(pet.nomePet, pet.id));
            });
        }
    });
}

function formatToReal(number) {
    return new Intl.NumberFormat('pt-BR', { style: 'currency', currency: 'BRL' }).format(number);
}

function loadPrestadores() {
    var tipoServico = $('#servico').val();
    $.ajax({
        url: '/agendamentos/prestadores/' + tipoServico,
        type: 'GET',
        success: function(prestadores) {
            var prestadorSelect = $('#prestador');
            prestadorSelect.empty();
            prestadorSelect.append(new Option("--SELECIONE UM PRESTADOR--", "", true, true));

            $.each(prestadores, function(index, prestador) {
                console.log(prestador);

                prestadorSelect.append(new Option(prestador.primeiroNome + " " + prestador.sobrenome, prestador.id));
            });
        }
    });

    $('#prestador').change(function() {
        var tipoServico = $('#servico').val();
        var prestadorId = $(this).val();

        if (prestadorId !== "") {
            $.ajax({
                url: '/agendamentos/prestador/' + prestadorId,
                type: 'GET',
                success: function(prestador) {
                    if (tipoServico === "PET_WALKER") {

                        $('#tempo-passeio-container').show();
                        $('#preco-passeio-container').show();
                        $('#preco-diaria-container').hide();

                        $('#tempo-med-passeio').val(prestador.petWalkerDTO.tempoPasseio);
                        $('#preco-passeio').val(formatToReal(prestador.petWalkerDTO.valorHoraPasseio));
                    } else if (tipoServico === "PET_SITTER") {
                        $('#preco-diaria-container').show();
                        $('#tempo-passeio-container').hide();
                        $('#preco-passeio-container').hide();

                        $('#preco-diaria').val(formatToReal(prestador.petWalkerDTO.valorPorDiaria));
                    }
                }
            });
        } else {

            $('#tempo-passeio-container').hide();
            $('#preco-passeio-container').hide();
            $('#preco-passeio-container').hide();
        }
    });
}

$('#idForm').on('submit', function(e) {

});