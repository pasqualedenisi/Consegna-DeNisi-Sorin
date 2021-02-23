/**
 * 
 */

window.addEventListener("load", function(){
	registerEvents();	
});

function registerEvents(){
	banButton.addEventListener("click", deleteUsers);
}

function deleteUsers(){
	var checkedBoxes = document.querySelectorAll('input[name=bancheck]:checked');
	checkedBoxes.forEach(function (checked, index){
		//elimina utente
		checked.parentNode.parentNode.remove();
	});
}