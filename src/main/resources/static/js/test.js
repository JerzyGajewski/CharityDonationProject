document.addEventListener("DOMContentLoaded", function () {

    let button = document.getElementById("last");

    button.addEventListener("click", function () {

        //category and bags number

        const bags = document.getElementById('bagQuantity').value;
        const id = document.getElementsByClassName('category');
        let categoryArr = [];
        for (let i = 0; i < id.length; i++) {
            if (id.item(i).checked === true) {
                categoryArr.push(id.item(i).parentElement.innerText);
            }
        }
        let categories = bags + ' worki z: ';
        let category = bags + ' worek z: ';
        for (let i = 0; i < categoryArr.length; i++) {
            if (bags == 1) {
                category = category + categoryArr[i];
                document.getElementById('cat').innerText = category;
            } else {
                categories = categories + categoryArr[i] + ' ';
                document.getElementById('cat').innerText = categories;
            }
        }


        // institution

        const institution = document.getElementsByClassName('radio');
        let institutionJs;
        for (let i = 0; i < institution.length; i++) {
            if (institution.item(i).checked === true) {
                institutionJs = institution.item(i).parentElement.querySelector(' div .title').innerText;

            }
        }
        document.getElementById('institutionJs').innerText = institutionJs;

        // client address

        const street = document.getElementById('street').value;
        const city = document.getElementById('city').value;
        const postcode = document.getElementById('postcode').value;
        const phone = document.getElementById('phone').value;

        document.getElementById('streetJs').innerText = 'ulica: ' + street;
        document.getElementById('cityJs').innerText = 'miasto: ' + city;
        document.getElementById('postcodeJs').innerText = 'kod pocztowy: ' + postcode;
        document.getElementById('phoneJs').innerText = 'telefon: ' + phone;

        // data to pickup

        const date = document.getElementById('pisckupDate').value;
        const time = document.getElementById('pickupTime').value;
        const desc = document.getElementById('comment').value;

        document.getElementById('dateJs').innerText = 'data odbioru: ' + date;
        document.getElementById('timeJs').innerText = 'godzina odbioru: ' + time;
        document.getElementById('descJs').innerText = 'dodatkowy opis: ' + desc;
    })
})