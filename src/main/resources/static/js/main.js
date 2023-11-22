/*=============== SHOW MODAL 2 ===============*/
const showModal_2 = (openButton, modalContent) =>{
    const openBtn = document.getElementById(openButton),
    modalContainer = document.getElementById(modalContent)

    
    if(openBtn && modalContainer){
        openBtn.addEventListener('click', ()=>{
            modalContainer.classList.add('show-modal')
            // closeModal_1();

        })
    }

}
showModal_2('open-modal_2','modal-container_2')

/*=============== CLOSE MODAL 2 ===============*/
const closeBtn_2 = document.querySelectorAll('.close-modal')

function closeModal_2(){
    const modalContainer = document.getElementById('modal-container_2')
    modalContainer.classList.remove('show-modal')
}
closeBtn_2.forEach(c => c.addEventListener('click', closeModal_2))


