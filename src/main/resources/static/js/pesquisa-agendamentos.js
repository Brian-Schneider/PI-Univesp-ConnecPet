function searchFunction() {
    var input, filter, cards, cardBody, i, txtValue;
    input = document.getElementById("search");
    console.log(input);
    filter = input.value.toUpperCase();
    cards = document.getElementsByClassName("card");

    for (i = 0; i < cards.length; i++) {
        cardBody = cards[i].getElementsByClassName("card-body")[0];
        txtValue = cardBody.textContent || cardBody.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
            cards[i].style.display = "";
        } else {
            cards[i].style.display = "none";
        }
    }
}