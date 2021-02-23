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
		console.log(checked.id);
		//elimina utente
		$.ajax({
			url: "ban",
			method: "POST",
			data: {id: checked.id},
			success: function(response){
				checked.parentNode.parentNode.remove();
				alert("Utenti eliminati con successo");},
			fail: function(){alert("fail");}
		});
	});
}