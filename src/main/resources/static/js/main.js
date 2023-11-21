// /*=============== SHOW MODAL 1 ===============*/
// const showModal_1 = (openButton, modalContent) =>{
//     const openBtn = document.getElementById(openButton),
//     modalContainer = document.getElementById(modalContent)
    
//     if(openBtn && modalContainer){
//         openBtn.addEventListener('click', ()=>{
//             modalContainer.classList.add('show-modal')
//         })
//     }
// }
// showModal_1('open-modal_1','modal-container_1')

// /*=============== CLOSE MODAL 1 ===============*/
// const closeBtn_1 = document.querySelectorAll('.close-modal')

// function closeModal_1(){
//     const modalContainer = document.getElementById('modal-container_1')
//     modalContainer.classList.remove('show-modal')
// }
// closeBtn_1.forEach(c => c.addEventListener('click', closeModal_1))


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


/*=============== SHOW MODAL 7 ===============*/
const showModal_7 = (openButton, modalContent) =>{
    const openBtn = document.getElementById(openButton),
    modalContainer = document.getElementById(modalContent)

    
    if(openBtn && modalContainer){
        openBtn.addEventListener('click', ()=>{
            modalContainer.classList.add('show-modal')
        })
    }

}
showModal_7('open-modal_7','modal-container_7')

/*=============== CLOSE MODAL 7 ===============*/
const closeBtn_7 = document.querySelectorAll('.close-modal')

function closeModal_7(){
    const modalContainer = document.getElementById('modal-container_7')
    modalContainer.classList.remove('show-modal')
}
closeBtn_7.forEach(c => c.addEventListener('click', closeModal_7))
