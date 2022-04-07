function Modal(triggerClass){

	this.trigger = triggerClass;

	this.init = function(){
		Array.from(document.querySelectorAll(this.trigger)).forEach((el)=>{
			el.addEventListener('click', (event)=>{
				console.log(event)
				let triggerAim = event.target.getAttribute('trigger');
				let triggerModal = document.querySelector(triggerAim);
				console.log(triggerAim,triggerModal)
				triggerModal.classList.remove('invisible');

			})
		})

		Array.from(document.querySelectorAll('.modal--desc-exit')).forEach((el)=>{
			el.addEventListener('click', (event)=>{
				let triggerAim = event.target.closest('.modal');

				triggerAim.classList.add('invisible');
				
			})
		})
	}

	this.modalHide = function(){
		Array.from(document.querySelectorAll('.modal')).forEach((el)=>{
			el.classList.add("invisible")
		})
	}

}