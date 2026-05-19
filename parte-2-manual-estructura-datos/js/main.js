document.addEventListener('DOMContentLoaded', () => {
    const enlaces_menu = document.querySelectorAll('.btn_accion_menu');
    
    enlaces_menu.forEach(enlace => {
        enlace.addEventListener('click', (evento) => {
            const titulo = evento.target.closest('.bloque_contenido').querySelector('.titulo_tema').textContent;
            console.log(`Accediendo al módulo técnico: ${titulo}`);
        });
    });
});