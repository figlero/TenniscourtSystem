function successModal(){
    M.toast({html: 'Nutzer erfolgreich angelegt!'})
}

function showToast(text){
    M.toast({html: text})
}

function navigate(page){
    window.location.href=page;
}