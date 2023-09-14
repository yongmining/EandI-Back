document.addEventListener('DOMContentLoaded', function() {
    const btn_here = document.querySelector('.button-here');
    const btn_togo = document.querySelector('.button-togo');

    if (btn_here) {
        btn_here.addEventListener('click', function() {
            window.location.href = 'menu/coffee';
        });
    }

    if (btn_togo) {
        btn_togo.addEventListener('click', function() {
            window.location.href = 'menu/coffee';
        });
    }
});

