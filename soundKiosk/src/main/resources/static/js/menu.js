document.addEventListener('DOMContentLoaded', function() {
    const btn_home = document.querySelector('.button-home');
    const menu_coffee = document.querySelector('.menu-coffee');
    const menu_tea = document.querySelector('.menu-tea');
    const menu_dessert = document.querySelector('.menu-dessert');

    if (btn_home) {
        btn_home.addEventListener('click', function() {
            window.location.href = '/main';
        });
    }

    if (menu_coffee) {
        menu_coffee.addEventListener('click', function() {
            window.location.href = '/menu/coffee';
        });
    }

    if (menu_tea) {
        menu_tea.addEventListener('click', function() {
            window.location.href = '/menu/tea';
        });
    }

    if (menu_dessert) {
        menu_dessert.addEventListener('click', function() {
            window.location.href = '/menu/dessert';
        });
    }
});